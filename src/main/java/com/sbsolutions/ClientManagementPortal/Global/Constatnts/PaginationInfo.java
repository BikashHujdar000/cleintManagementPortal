package com.sbsolutions.ClientManagementPortal.Global.Constatnts;

public record PaginationInfo(int currentPage, int pageSize, long totalRecord, int totalPage, boolean lastPage) {
}
