package com.example.application;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @PreAuthorize("hasRole('ROLE_group1')")
    @RequestMapping("/group1")
    public String groupOne(@AuthenticationPrincipal(expression = "claims['name']")String name) {
        return String.format("Hello %s!",name);
    }
    @PreAuthorize("hasRole('ROLE_group2')")
    @RequestMapping("/Group2")
    public String groupTwo() {
        return "Hello Group 2 Users!";
    }
}