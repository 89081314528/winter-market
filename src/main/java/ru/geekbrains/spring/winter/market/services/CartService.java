package ru.geekbrains.spring.winter.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.winter.market.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private List<Product> cart = new ArrayList<>();

    public void addToCart(Product product) {
        cart.add(product);
    }

    public List<Product> findAll() {
        return cart;
    }
}
