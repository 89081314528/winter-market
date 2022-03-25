package ru.geekbrains.winter.market.carts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.winter.market.api.CategoryDto;
import ru.geekbrains.winter.market.api.ProductDto;
import ru.geekbrains.winter.market.carts.integrations.ProductServiceIntegration;
import ru.geekbrains.winter.market.carts.model.Cart;
import ru.geekbrains.winter.market.carts.services.CartService;
import java.math.BigDecimal;

@SpringBootTest
public class CartServiceTest {
    @Autowired
    private CartService cartService;
    @MockBean
    private ProductServiceIntegration productServiceIntegration;
    @MockBean
    private Cart tempCart;

//    @Test
//    void removeTest() {
//        cartService.remove(1L);
//        Mockito.verify(tempCart, Mockito.times(1)).remove(1L);
//    }

    @Test
    void addTest() {
        CategoryDto category = new CategoryDto();
        category.setId(1L);
        category.setTitle("other");

        ProductDto productDto = new ProductDto();
        productDto.setId(111L);
        productDto.setPrice(new BigDecimal(120));
        productDto.setTitle("Apple");
        productDto.setCategoryTitle(category.getTitle());

        Mockito.doReturn(productDto).when(productServiceIntegration).getProductById(111L);
        cartService.add(111L);
        Mockito.verify(productServiceIntegration, Mockito.times(1)).getProductById(111L);
    }
}
