package ru.geekbrains.winter.market.carts.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.winter.market.api.CartDto;
import ru.geekbrains.winter.market.api.StringResponse;
import ru.geekbrains.winter.market.carts.convertes.CartConverter;
import ru.geekbrains.winter.market.carts.model.Cart;
import ru.geekbrains.winter.market.carts.services.CartService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id,
     @RequestParam(name = "userName", required = false)
                String userName)
    {
        cartService.add(id, userName);
    }

    @GetMapping
    public CartDto getCurrentCart(@RequestParam(name = "userName", required = false)
                                              String userName) {
        return cartConverter.entityToDto(cartService.getCurrentCart(userName));
    }

    @GetMapping("/clear")
    public void clearCart(@RequestParam(name = "userName", required = false) String userName) {
        cartService.clear(userName);
    }

    @GetMapping("/remove/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartService.remove(id);
    }

}
