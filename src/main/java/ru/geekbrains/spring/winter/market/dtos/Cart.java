package ru.geekbrains.spring.winter.market.dtos;

import lombok.Data;
import ru.geekbrains.spring.winter.market.entities.Product;

import java.util.*;

@Data
public class Cart {
    private Map<Long, CartItem> items;
    private int totalPrice;

    public Cart() {
        this.items = new HashMap<>();
    }

    public List<CartItem> getItems() {
        List<CartItem> itemList = new ArrayList<>();
        for (CartItem item : items.values()) {
            itemList.add(item);
        }
        return Collections.unmodifiableList(itemList);
    }

    public void add(Product product) { // TODO: Доработать в ДЗ
        Long productId = product.getId();
        if (items.containsKey(productId)) {
            CartItem current = items.get(productId);
            current.setQuantity(current.getQuantity() + 1);
            current.setPrice(current.getQuantity() * current.getPricePerProduct());
            items.put(productId, current);
        } else {
            items.put(productId, new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));
        }
        recalculate();
    }

    private void recalculate() {
        totalPrice = 0;
        for (CartItem item : items.values()) {
            totalPrice += item.getPrice();
        }
    }

    public void emptyCart() {
        items.clear();
        recalculate();
    }
}
