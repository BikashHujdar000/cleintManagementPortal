package com.sbsolutions.clientmanagement.Global.Constatnts;

public record PaginationInfo(int currentPage, int pageSize, long totalRecord, int totalPage, boolean lastPage) {
}
