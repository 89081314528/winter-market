package ru.geekbrains.spring.winter.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.winter.market.dtos.OrderDto;
import ru.geekbrains.spring.winter.market.entities.Order;
import ru.geekbrains.spring.winter.market.entities.User;
import ru.geekbrains.spring.winter.market.model.Cart;
import ru.geekbrains.spring.winter.market.services.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getOrders")
    public List<OrderDto> getOrders(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException());
        return userService.getOrders(user);

    }
}
