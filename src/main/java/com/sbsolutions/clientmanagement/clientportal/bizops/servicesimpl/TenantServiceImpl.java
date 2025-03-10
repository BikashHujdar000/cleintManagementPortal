package com.sbsolutions.clientmanagement.clientportal.bizops.servicesimpl;


import com.sbsolutions.clientmanagement.clientportal.web.exceptions.DatabaseOperationException;
import com.sbsolutions.clientmanagement.clientportal.web.exceptions.ResourceNotFoundException;
import com.sbsolutions.clientmanagement.clientportal.bizops.mappers.*;
import com.sbsolutions.clientmanagement.clientportal.bizops.repositories.TenantRepository;
import com.sbsolutions.clientmanagement.clientportal.bizops.entities.*;
import com.sbsolutions.clientmanagement.clientportal.bizops.services.*;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@Transactional
@Service
public class TenantServiceImpl implements TenantService {
    private final WebClient webClient;
    private final TenantRepository tenantRepository;
    private final AdminConfigurationService adminConfigurationService;
    private final DatabaseConfigurationService databaseConfigurationService;
    private final OrganizationAddressService organizationAddressService;
    private final ThemeConfigurationService themeConfigurationService;
    private final SubscriptionTierService subscriptionTierService;


    public TenantServiceImpl(WebClient webClient, TenantRepository tenantRepository, AdminConfigurationService adminConfigurationService, DatabaseConfigurationService databaseConfigurationService, OrganizationAddressService organizationAddressService, ThemeConfigurationService themeConfigurationService, SubscriptionTierService subscriptionTierService) {
        this.webClient = webClient;
        this.tenantRepository = tenantRepository;
        this.adminConfigurationService = adminConfigurationService;
        this.databaseConfigurationService = databaseConfigurationService;
        this.organizationAddressService = organizationAddressService;
        this.themeConfigurationService = themeConfigurationService;
        this.subscriptionTierService = subscriptionTierService;
    }

    @Value("${client.creation.api}")
    private  String apiUrl ;

    @Transactional
    @Override
    public TenantDTO createTenant(TenantDTO tenantDTO) {


        // Validate required fields
        if (tenantDTO.getOrganizationName() == null || tenantDTO.getOrganizationEmail() == null) {
            throw new IllegalArgumentException("Organization Name and Email are required.");
        }


        try {


            // Convert DTO to Entity
            Tenant tenant = new Tenant();

            tenant.setOrganizationName(tenantDTO.getOrganizationName());
            tenant.setOrganizationSwiftcode(tenantDTO.getOrganizationSwiftcode());
            tenant.setOrganizationEmail(tenantDTO.getOrganizationEmail());
            tenant.setSubDomainName(tenantDTO.getSubDomainName());
            tenant.setPhoneNumber(tenantDTO.getPhoneNumber());
            tenant.setPlanType(tenantDTO.getPlanType());
            tenant.setCreatedDate(LocalDateTime.now());
            tenant.setExpirationDate(LocalDateTime.now().plusMonths(1));
            tenant.setActive(false);

            // Save Admin Configuration
            if (tenantDTO.getAdminConfiguration() != null) {
                AdminConfigurationDTO adminConfigurationDTO = tenantDTO.getAdminConfiguration();
                AdminConfiguration savedAdminConfigurationD = AdminConfigurationMapper.toEntity(this.adminConfigurationService.createAdminConfiguration(adminConfigurationDTO));
                tenant.setAdminConfiguration(savedAdminConfigurationD);
            }

            // Save Theme Configuration
            if (tenantDTO.getThemeConfiguration() != null) {

                ThemeConfigurationDTO themeConfigurationDTO = tenantDTO.getThemeConfiguration();
                ThemeConfiguration themeConfig = ThemeConfigurationMapper.toEntity(this.themeConfigurationService.createThemeConfiguration(themeConfigurationDTO));
                tenant.setThemeConfiguration(themeConfig);
            }

            // Save Organization Address
            if (tenantDTO.getOrganizationAddress() != null) {
                OrganizationAddressDTO organizationAddressDTO = tenantDTO.getOrganizationAddress();
                OrganizationAddress organizationAddress = OrganizationAddressMapper.toEntity(this.organizationAddressService.createOrganizationAddress(organizationAddressDTO));
                tenant.setOrganizationAddress(organizationAddress);
            }

            // Save Database Configuration
            if (tenantDTO.getDatabaseConfiguration() != null) {
                DatabaseConfigurationDTO databaseConfigurationDTO = tenantDTO.getDatabaseConfiguration();
                DatabaseConfiguration databaseConfiguration = DatabaseConfigurationMapper.toEntity(this.databaseConfigurationService.createDatabaseConfiguration(databaseConfigurationDTO));
                tenant.setDatabaseConfiguration(databaseConfiguration);
            }

            // Set Subscription Tier (fetch existing)
            if (tenantDTO.getSubscriptionTier() != null && tenantDTO.getSubscriptionTier().getSubscriptionTierId() != null) {
                SubscriptionTier subscriptionTier = SubscriptionTierMapper.toEntity(subscriptionTierService.getSubscriptionTierById(tenantDTO.getSubscriptionTier().getSubscriptionTierId()));
                tenant.setSubscriptionTier(subscriptionTier);
            }

            Tenant savedTenant = this.tenantRepository.save(tenant);

            log.info("Saved tenant {}", savedTenant);


            //adding the client api to set the client information in the  core app

            ClientRegisterDto clientRegisterDto = new ClientRegisterDto();
            clientRegisterDto.setName(tenantDTO.getOrganizationName());
            clientRegisterDto.setSubdomain(tenantDTO.getSubDomainName());
            clientRegisterDto.setDbName(tenantDTO.getOrganizationSwiftcode());
            clientRegisterDto.setDbUrl(tenantDTO.getDatabaseConfiguration().getDbUrl());
            clientRegisterDto.setDbUsername(tenantDTO.getDatabaseConfiguration().getDbCredentialUsername());
            clientRegisterDto.setDbPassword(tenantDTO.getDatabaseConfiguration().getDbCredentialPassword());
            clientRegisterDto.setAdminEmail(tenantDTO.getAdminConfiguration().getEmail());
            clientRegisterDto.setAdminUsername(tenantDTO.getAdminConfiguration().getUsername());
            clientRegisterDto.setAdminPassword(tenantDTO.getAdminConfiguration().getPassword());
            clientRegisterDto.setIsolationType("DATABASE");


            Mono<TenantResponse> tenantResponseMono = null;
            try {

                tenantResponseMono = webClient.post()
                        .uri(apiUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(clientRegisterDto)
                        .retrieve()
                        .bodyToMono(TenantResponse.class)
                        .doOnSuccess(response -> log.info("Tenant created successfully: {}", response));

            } catch (Exception e) {
                throw new DatabaseOperationException("Failed to call an External Api : " + e.getMessage());
            }

            TenantResponse response = tenantResponseMono.block();

            log.info("Tenant created successfully: {}", response);

            return TenantMapper.toDTO(savedTenant);

        } catch (Exception e) {
            throw new DatabaseOperationException("Failed to save tenant to the database :" + e.getMessage());
        }


    }

    @Override
    public TenantDTO updateTenant(Long tenantId, TenantDTO tenantDTO) {
        throw new DatabaseOperationException("Updating the tenant Information is not supported");
    }


    @Override
    public TenantDTO getTenantById(Long tenantId) {
        try {
            Tenant tenant = tenantRepository.findById(tenantId)
                    .orElseThrow(() -> new ResourceNotFoundException("Tenant", "Tenant Id ", tenantId));
            return TenantMapper.toDTO(tenant);
        } catch (Exception e) {
            throw new DatabaseOperationException("Failed to retrieve the data from the database :" + e.getMessage());
        }

    }

    @Override
    public List<TenantDTO> getAllTenants() {
        try {
            List<Tenant> tenants = tenantRepository.findAll();
            return tenants.stream().map(TenantMapper::toDTO).toList();
        } catch (Exception e) {
            throw new DatabaseOperationException("Failed to retrieve the data from the database :" + e.getMessage());
        }

    }



    @Override
    public DeletionResponse deleteTenant(Long tenantId) {

        try {
            Tenant tenant = tenantRepository.findById(tenantId)
                    .orElseThrow(() -> new ResourceNotFoundException("Tenant", "Tenant Id ", tenantId));
            tenantRepository.deleteById(tenant.getTenantId());
            DeletionResponse response = new DeletionResponse(true, "Tenant deleted successfully With tenantId: " + tenantId);
            return response;

        } catch (Exception e) {
            throw new DatabaseOperationException("Failed to delete the data from the database : " + e.getMessage());
        }

    }

    @Override
    public List<Clients> getAllClients() {

        try {
            List<Tenant> tenants = tenantRepository.findAll();
            return tenants.stream().map(ClientMapper::toClientsDto).toList();
        } catch (Exception e) {
            throw new DatabaseOperationException("Failed to retrieve the data from the database :" + e.getMessage());
        }

    }

    //fo the pageable
    @Override
    public Page<TenantDTO> getAll(Pageable pageable) {

        Page<Tenant> tenantPage = this.tenantRepository.findAll(pageable);


        log.info("Get all tenants with pageable {}", tenantPage);


        // Use TenantMapper.toDTO to convert each Tenant entity to a TenantDTO
        Page<TenantDTO> tenantDTOPage = tenantPage.map(TenantMapper::toDTO);
        return tenantDTOPage;


    }

    // for the pageable form
//    @Override
//    public Page<LoanResponseInList> getAll(Pageable pageable) {
//        return this.loanApplicationRepository.findAllLoans(pageable);
//    }


}
