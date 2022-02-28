package ru.geekbrains.spring.winter.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.winter.market.entities.Order;
import ru.geekbrains.spring.winter.market.entities.OrderItem;
import ru.geekbrains.spring.winter.market.entities.User;
import ru.geekbrains.spring.winter.market.model.Cart;
import ru.geekbrains.spring.winter.market.model.CartItem;
import ru.geekbrains.spring.winter.market.repositories.OrderRepository;
import ru.geekbrains.spring.winter.market.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductService productService;
    private final CartService cartService;
    private final OrderRepository orderRepository;

    public void createOrder(User user) {
        Cart cart = cartService.getCurrentCart();
        List<CartItem> cartItems = cart.getItems();

        Order order = new Order();
        order.setUser(user); // почему не userId?
        order.setTotalPrice(cart.getTotalPrice());

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cartItems) { // можно использовать гет?
            orderItems.add(new OrderItem(productService.findById(cartItem.getProductId()).get(), order,
                    cartItem.getQuantity(), cartItem.getPricePerProduct(), cartItem.getPrice()));
        }

        order.setItems(orderItems);
        orderRepository.save(order);
    }
}
