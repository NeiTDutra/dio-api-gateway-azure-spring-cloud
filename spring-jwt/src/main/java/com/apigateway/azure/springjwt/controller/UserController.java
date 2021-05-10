package com.apigateway.azure.springjwt.controller;

import com.apigateway.azure.springjwt.data.UserData;
import com.apigateway.azure.springjwt.service.UserDetailServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserDetailServiceImpl userDetailService;

    public UserController(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @RequestMapping("/all-users")
    public List<UserData> listAllUsers() {
        return userDetailService.listUsers();
    }
}
