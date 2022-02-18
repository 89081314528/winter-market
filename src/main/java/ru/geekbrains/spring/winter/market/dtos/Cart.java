package ru.geekbrains.spring.winter.market.dtos;

import lombok.Data;
import ru.geekbrains.spring.winter.market.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<Product> products = new ArrayList<>();

    public Cart(List<Product> products) {
        this.products = products;
    }
}
