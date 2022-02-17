package ru.geekbrains.spring.winter.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.winter.market.entities.Product;
import ru.geekbrains.spring.winter.market.services.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<Product> findAll() {
        return cartService.findAll();
    }
}
