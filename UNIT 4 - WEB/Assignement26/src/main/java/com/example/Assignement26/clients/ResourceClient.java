package com.example.Assignement26.clients;

import com.example.Assignement26.response.resourceResponses.MultipleResourceResponse;
import com.example.Assignement26.response.resourceResponses.SingleResourceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "resource-clint", url = "https://reqres.in")
public interface ResourceClient {

    @GetMapping("/api/unknown/{id}")
    SingleResourceResponse getSingleResource(@PathVariable(name = "id") Integer id);

    @GetMapping("/api/unknown")
    MultipleResourceResponse getResourcesList(@RequestParam(name = "page") Integer id);

    @GetMapping("/api/register")
    MultipleResourceResponse register();
}
