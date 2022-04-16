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
    public String admin(@RequestParam(required = false) String role){
        System.out.println("начал выполняться метод админ");
        if(role == null) {
            System.out.println("ошибка роль равна null");
            throw new RuntimeException("ошибка роль равна null");
        } else if (role.equals("admin")) {
            System.out.println("роль админ");
            return "{\"role\" : \"admin\"}";
        } else {
            System.out.println("ошибка роль не админ");
            throw new RuntimeException("ошибка роль не админ");
        }
    }
}
