package com.example.Assignement26.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class PageInfo {
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
}
