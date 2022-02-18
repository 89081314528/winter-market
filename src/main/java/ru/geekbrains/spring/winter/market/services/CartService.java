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

    private List<Product> productList = new ArrayList<>();
//почему лист надо создавать в @PostConstruct, а не в строке 15? Что случится плохого, если создать лист в 15 строке?
//    @PostConstruct
//    public void init(){
//        this.productList = new ArrayList<>();
//    }

    private final ProductService productService;

    public void addToCart(Long id) {
        Product product = productService.findById(id).get();
        productList.add(product);
    }

    public Cart getCart() {
        //почему нежелательно возвращать здесь лист продуктов?
        return new Cart(new ArrayList<>(productList));
    }
}
