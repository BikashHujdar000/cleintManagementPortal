package com.sbsolutions.ClientManagementPortal.ClientManagement.ServicesImpl;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.*;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Mappers.*;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.*;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories.SubscriptionTierRepository;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories.TenantRepository;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Services.*;
import com.sbsolutions.ClientManagementPortal.Global.Exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Transactional
@Service
public class TenantServiceImpl implements TenantService {
    private final TenantRepository tenantRepository;
    private final AdminConfigurationService adminConfigurationService;
    private final DatabaseConfigurationService databaseConfigurationService;
    private final OrganizationAddressService organizationAddressService;
    private final ThemeConfigurationService themeConfigurationService;
    private final SubscriptionTierService subscriptionTierService;


    public TenantServiceImpl(TenantRepository tenantRepository, AdminConfigurationService adminConfigurationService, DatabaseConfigurationService databaseConfigurationService, SubscriptionTierRepository subscriptionTierRepository1, OrganizationAddressService organizationAddressService, ThemeConfigurationService themeConfigurationService, SubscriptionTierService subscriptionTierService) {

        this.tenantRepository = tenantRepository;
        this.adminConfigurationService = adminConfigurationService;
        this.databaseConfigurationService = databaseConfigurationService;
        this.organizationAddressService = organizationAddressService;
        this.themeConfigurationService = themeConfigurationService;
        this.subscriptionTierService = subscriptionTierService;
    }

    @Transactional
    @Override
    public TenantDTO createTenant(TenantDTO tenantDTO) {


        // Validate required fields
        if (tenantDTO.getOrganizationName() == null || tenantDTO.getOrganizationEmail() == null) {
            throw new IllegalArgumentException("Organization Name and Email are required.");
        }

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
            log.info("Subscription Tier found with ID {}, subscriptionTier.toString()");

            tenant.setSubscriptionTier(subscriptionTier);
        }
        log.info("Tenant To be saved here ",  tenant.toString());

        Tenant savedTenant = this.tenantRepository.save(tenant);

        log.info("Saved tenant {}", savedTenant);
        return TenantMapper.toDTO(savedTenant);

    }


    @Override
    public TenantDTO updateTenant(Long tenantId, TenantDTO tenantDTO) {
        return null;
    }

    @Override
    public TenantDTO getTenantById(Long tenantId) {
        return null;
    }

    @Override
    public List<TenantDTO> getAllTenants() {
        return List.of();
    }

    @Override
    public void deleteTenant(Long tenantId) {

    }
}
