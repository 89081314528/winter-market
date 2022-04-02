package ru.geekbrains.winter.market.carts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.winter.market.api.ProductDto;
import ru.geekbrains.winter.market.carts.integrations.ProductServiceIntegration;
import ru.geekbrains.winter.market.carts.model.Cart;

import javax.annotation.PostConstruct;

@Service
public class CartService {
    private final ProductServiceIntegration productServiceIntegration;
    private Cart tempCart;
    // сначала создаются поля, в них null
    public CartService(ProductServiceIntegration productServiceIntegration) {
        this.productServiceIntegration = productServiceIntegration;
    }
// ProductServiceIntegration productServiceIntegration присваивается ссылка на мок из контекста
    // ниже создается new Cart() (находится в классе)
    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart() {
        return tempCart;
    }

    public void add(Long productId) { // в тесте проверить, что productServiceIntegration вызывается один раз, tempCart не инжектится
        // в корзине сделать поле с юзером
        //передать сюда имя пользователя из параметра
        //по имени пользователя искать корзину. если ее нет создать новую
        ProductDto product = productServiceIntegration.getProductById(productId);
        tempCart.add(product);
    }

    public void remove(Long productId) {
        tempCart.remove(productId);
    }

    public void clear() {
        tempCart.clear();
    }
}
