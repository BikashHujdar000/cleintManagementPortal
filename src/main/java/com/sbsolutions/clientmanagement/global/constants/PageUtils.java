package com.sbsolutions.clientmanagement.global.constants;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import javax.swing.*;

public class PageUtils<T> {

    public static PageRequest prepareFilterCriteria(SearchCriteria searchCriteria) {
        // Ensure valid pagination values
        if (searchCriteria.getCurrentPage() <= 0) {
            searchCriteria.setCurrentPage(1);
        }
        if (searchCriteria.getPageSize() <= 0) {
            searchCriteria.setPageSize(10);
        }

        // If sortBy is empty, create a PageRequest without sorting.
        if (!StringUtils.hasText(searchCriteria.getSortBy())) {
            return PageRequest.of(searchCriteria.getCurrentPage() - 1, searchCriteria.getPageSize());
        }

        // Apply sort order if a sort field is provided.
        if (searchCriteria.getSortOrder().equalsIgnoreCase(SortOrder.ASCENDING.name())) {
            return PageRequest.of(
                    searchCriteria.getCurrentPage() - 1,
                    searchCriteria.getPageSize(),
                    Sort.by(searchCriteria.getSortBy()).ascending()
            );
        } else {
            return PageRequest.of(
                    searchCriteria.getCurrentPage() - 1,
                    searchCriteria.getPageSize(),
                    Sort.by(searchCriteria.getSortBy()).descending()
            );
        }
    }

    public static <T> PaginationInfo preparePaginationInfo(SearchCriteria searchCriteria, Page<T> pageData) {
        return new PaginationInfo(
                searchCriteria.getCurrentPage(),
                pageData.getSize(),
                pageData.getTotalElements(),
                pageData.getTotalPages(),
                pageData.isLast()
        );
    }
}
