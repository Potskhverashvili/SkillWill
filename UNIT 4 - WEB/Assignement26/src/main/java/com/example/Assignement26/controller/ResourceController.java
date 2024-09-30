package com.example.Assignement26.controller;

import com.example.Assignement26.clients.ResourceClient;
import com.example.Assignement26.response.resourceResponses.MultipleResourceResponse;
import com.example.Assignement26.response.resourceResponses.SingleResourceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    private final ResourceClient resourceClient;
    public ResourceController(ResourceClient resourceClient) {
        this.resourceClient = resourceClient;
    }

    @GetMapping("resource/{id}")
    SingleResourceResponse getSingleResource(@PathVariable(name = "id")Integer id){
        return resourceClient.getSingleResource(id);
    }

    @GetMapping("/resources")
    MultipleResourceResponse getResourcesList(@RequestParam(name = "page") Integer page){
        return resourceClient.getResourcesList(page);
    }

    @GetMapping("/register")
    MultipleResourceResponse register(){
        return resourceClient.register();
    }
}
