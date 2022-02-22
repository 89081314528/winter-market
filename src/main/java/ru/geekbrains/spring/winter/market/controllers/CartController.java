package ru.geekbrains.spring.winter.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.winter.market.dtos.Cart;
import ru.geekbrains.spring.winter.market.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @GetMapping("/emptyCart")
    public void emptyCart() {
        cartService.emptyCart();
    }

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/increaseNumberOfProducts/{id}")
    public void increaseNumberOfProducts(@PathVariable Long id) {
        cartService.increaseNumberOfProducts(id);
    }

    @GetMapping("/reduceNumberOfProducts/{id}")
    public void reduceNumberOfProducts(@PathVariable Long id) {
        cartService.reduceNumberOfProducts(id);
    }

    @GetMapping("/deleteProductFromCart/{id}")
    public void deleteProductFromCart(@PathVariable Long id) {
        cartService.deleteProductFromCart(id);
    }
}
