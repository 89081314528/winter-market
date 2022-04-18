package ru.geekbrains.winter.market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    @GetMapping("/admin")
    public String admin(@RequestHeader(name = "roles", required = false) List<String> role) {
        System.out.println("начал выполняться метод админ");
        if (role == null) {
            System.out.println("ошибка роль равна null");
            throw new RuntimeException("ошибка роль равна null");
        } else if (role.contains("ROLE_ADMIN")) {
            System.out.println("роль админ");
            return "{\"value\" : \"admin\"}";
        } else {
            System.out.println("ошибка роль не админ");
            throw new RuntimeException("ошибка роль не админ");
        }
    }
}
