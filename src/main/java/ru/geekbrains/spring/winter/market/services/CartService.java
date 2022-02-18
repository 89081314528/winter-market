package ru.geekbrains.spring.winter.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.winter.market.entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private List<Product> productList;

    @PostConstruct
    public void init(){
        this.productList = new ArrayList<>();
    }

    private final ProductService productService;

    public void addToCart(Long id) {
        Product product = productService.findById(id).get();
        productList.add(product);
    }

    public List<Product> findAll() {
        return productList;
    }
}
