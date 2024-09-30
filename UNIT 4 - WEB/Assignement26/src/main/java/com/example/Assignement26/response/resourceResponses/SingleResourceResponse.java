package com.example.Assignement26.response.resourceResponses;

import com.example.Assignement26.models.Resource;
import com.example.Assignement26.models.Support;
import lombok.Data;

@Data
public class SingleResourceResponse {
    private Resource data;
    private Support support;
}
