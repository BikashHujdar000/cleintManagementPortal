package com.sbsolutions.clientmanagement.global.constants;

public record PaginationInfo(int currentPage, int pageSize, long totalRecord, int totalPage, boolean lastPage) {
}
