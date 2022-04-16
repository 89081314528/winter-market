package ru.geekbrains.winter.market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    @GetMapping("/admin")
    public String admin(@RequestParam(required = false) String role) {
        System.out.println("метод вызван");
        if (role == null) {
            throw new RuntimeException();
        } else if (role.equals("admin")) {
            return "{\"value\" : \"admin\"}";
        } else {
            throw new RuntimeException();
        }
    }
}
