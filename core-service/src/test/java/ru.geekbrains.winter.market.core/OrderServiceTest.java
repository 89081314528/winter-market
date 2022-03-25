package ru.geekbrains.winter.market.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.winter.market.api.CartDto;
import ru.geekbrains.winter.market.api.CartItemDto;
import ru.geekbrains.winter.market.core.entities.Category;
import ru.geekbrains.winter.market.core.entities.Order;
import ru.geekbrains.winter.market.core.entities.Product;
import ru.geekbrains.winter.market.core.integrations.CartServiceIntegration;
import ru.geekbrains.winter.market.core.repositories.OrderRepository;
import ru.geekbrains.winter.market.core.services.OrderService;
import ru.geekbrains.winter.market.core.services.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @MockBean
    private ProductService productService;
    @MockBean
    private OrderRepository orderRepository;
    @MockBean
    private CartServiceIntegration cartServiceIntegration;

    @Test
    public void createOrderTest() { // все методы тестов void
        CartDto cartDto = new CartDto();

        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductTitle("Juice");
        cartItemDto.setPricePerProduct(new BigDecimal(120));
        cartItemDto.setQuantity(2);
        cartItemDto.setPrice(new BigDecimal(240));
        cartItemDto.setProductId(19224L);

        cartDto.setTotalPrice(new BigDecimal(240));
        cartDto.setItems(List.of(cartItemDto));

        Mockito.doReturn(cartDto).when(cartServiceIntegration).getCurrentCart();

        Category category = new Category();
        category.setId(1L);
        category.setTitle("Other");

        Product product = new Product();
        product.setId(19224L);
        product.setPrice(new BigDecimal(120));
        product.setTitle("Juice");
        product.setCategory(category);

        Mockito.doReturn(Optional.of(product)).when(productService).findById(19224L);

        Order order = orderService.createOrder("bob");
        Assertions.assertEquals(new BigDecimal(240), order.getTotalPrice());
        Mockito.verify(orderRepository, Mockito.times(1)).save(ArgumentMatchers.any());


    }
}
