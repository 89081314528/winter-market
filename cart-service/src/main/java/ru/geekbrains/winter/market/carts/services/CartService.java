package ru.geekbrains.winter.market.carts.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.winter.market.api.ProductDto;
import ru.geekbrains.winter.market.api.ResourceNotFoundException;
import ru.geekbrains.winter.market.carts.integrations.ProductServiceIntegration;
import ru.geekbrains.winter.market.carts.model.Cart;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productServiceIntegration;
    private Cart tempCart;
    private HashMap<String, Cart> userCarts = new HashMap<>();

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart(String userName) {
        if(userName == null) {
            return tempCart;
        } else {
            return userCarts.get(userName);
        }
    }

    public void add(Long productId, String userName) {
        ProductDto product = productServiceIntegration.getProductById(productId);
        if(userName == null) {
            tempCart.add(product);
        } else if (userCarts.containsKey(userName)) {
            Cart userCart= userCarts.get(userName);
            userCart.add(product);
            userCarts.put(userName,userCart);
        } else {
            Cart userCart = new Cart();
            userCart.add(product);
            userCarts.put(userName,userCart);
        }
    }

    public void remove(Long productId) {
        tempCart.remove(productId);
    }

    public void clear(String userName) {
        if (userName == null) {
            tempCart.clear();
        } else {
            Cart userCart = userCarts.get(userName);
            userCart.clear();
        }
    }
}
