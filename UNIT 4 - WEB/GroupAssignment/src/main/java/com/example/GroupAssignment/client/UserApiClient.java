package com.example.GroupAssignment.client;

import com.example.GroupAssignment.DTO.userApiDto.UserApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "user-client", url = "https://reqres.in")
public interface UserApiClient {

    @GetMapping("/api/users")
    UserApiResponse getAllUsers();
}
