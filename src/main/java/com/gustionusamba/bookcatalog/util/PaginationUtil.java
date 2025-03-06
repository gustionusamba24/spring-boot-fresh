package com.gustionusamba.bookcatalog.util;

import org.springframework.data.domain.Sort;

public class PaginationUtil {

    public static Sort.Direction getSortBy(String sortBy) {
        if (sortBy.equalsIgnoreCase("asc")) {
            return Sort.Direction.ASC;
        } else {
            return Sort.Direction.DESC;
        }
    }
}
