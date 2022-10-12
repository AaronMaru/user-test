package com.example.usertest.response;

import lombok.Data;

@Data
public class PagingRS {
    private Integer page;
    private Integer size;
    private Long totals;

    public PagingRS(Integer page, Integer size, Long totals) {
        this.page = page;
        this.size = size;
        this.totals = totals;
    }

    public PagingRS() {
    }
}
