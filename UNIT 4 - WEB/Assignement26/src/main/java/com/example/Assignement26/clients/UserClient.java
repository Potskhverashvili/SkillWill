package com.example.Assignement26.clients;

import com.example.Assignement26.response.userResponses.MultipleUserResponse;
import com.example.Assignement26.response.userResponses.SingleUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-client", url = "https://reqres.in")
public interface UserClient {

    @GetMapping("/api/users/{id}")
    SingleUserResponse getUser(@PathVariable(name = "id") Integer id);

    @GetMapping("/api/users")
    MultipleUserResponse getUsersList(@RequestParam(name = "page") Integer page);

    @GetMapping("/api/users")
    MultipleUserResponse delayResponse(@RequestParam(name = "delay") Integer delay);
}