package com.sbsolutions.clientmanagement.global.constants;

import org.springframework.util.ObjectUtils;

import javax.swing.*;

public class SearchCriteria {
    // No default sort field; can be empty if not applicable
    private String sortBy;
    private String sortOrder = SortOrder.ASCENDING.name();
    private int currentPage = 1;
    private int pageSize = 10;
    private String[] searchParameter;

    public SearchCriteria(String sortBy, String sortOrder, int currentPage, int pageSize, String[] searchParameter) {
        // Accept sortBy as-is; no exception is thrown if it's empty.
        this.sortBy = sortBy;
        this.sortOrder = ObjectUtils.isEmpty(sortOrder) ? SortOrder.DESCENDING.name() : sortOrder;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.searchParameter = searchParameter;
    }

    // Getters and setters

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String[] getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(String[] searchParameter) {
        this.searchParameter = searchParameter;
    }
}
