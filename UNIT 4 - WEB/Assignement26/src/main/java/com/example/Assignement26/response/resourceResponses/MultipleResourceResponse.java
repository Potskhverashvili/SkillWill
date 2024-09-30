package com.example.Assignement26.response.resourceResponses;

import com.example.Assignement26.models.PageInfo;
import com.example.Assignement26.models.Resource;
import com.example.Assignement26.models.Support;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class MultipleResourceResponse extends PageInfo {
    private List<Resource> data;
    private Support support;
}
