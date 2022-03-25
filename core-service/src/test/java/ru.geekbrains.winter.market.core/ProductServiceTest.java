package ru.geekbrains.winter.market.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.winter.market.api.ProductDto;
import ru.geekbrains.winter.market.core.converters.ProductConverter;
import ru.geekbrains.winter.market.core.entities.Category;
import ru.geekbrains.winter.market.core.entities.Product;
import ru.geekbrains.winter.market.core.repositories.ProductRepository;
import ru.geekbrains.winter.market.core.services.CategoryService;
import ru.geekbrains.winter.market.core.services.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private CategoryService categoryService;

    @Test
    public void findAllTest() {
        Category category = new Category();
        category.setId(1L);
        category.setTitle("other");

        Product product = new Product();
        product.setId(111L);
        product.setPrice(new BigDecimal(120));
        product.setTitle("Apple");
        product.setCategory(category);

        List<Product> products = new ArrayList<>();
        products.add(product);

        Mockito.doReturn(products).when(productRepository).findAll();
        Assertions.assertEquals(productService.findAll(), products); // или тут лучше достать название продукта?
    }

    @Test
    public void findByIdTest() {
        Category category = new Category();
        category.setId(1L);
        category.setTitle("other");

        Product product = new Product();
        product.setId(111L);
        product.setPrice(new BigDecimal(120));
        product.setTitle("Apple");
        product.setCategory(category);

        Mockito.doReturn(Optional.of(product)).when(productRepository).findById(111L);
        Assertions.assertEquals(productService.findById(111L), Optional.of(product));
    }

    @Test
    public void deleteByIdTest() {
        productService.deleteById(1L);
        Mockito.verify(productRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void createNewProductTest() { // надо ли вносить айди при создании продукта? если нет, то надо убрать поле id из ProductDto
        Category category = new Category();
        category.setId(1L);
        category.setTitle("other");

        Product product = new Product();
        product.setId(111L);
        product.setPrice(new BigDecimal(120));
        product.setTitle("Apple");
        product.setCategory(category);
        ProductDto productDto = new ProductDto();
        productDto.setId(111L);
        productDto.setPrice(new BigDecimal(120));
        productDto.setTitle("Apple");
        productDto.setCategoryTitle(category.getTitle());

        Mockito.doReturn(Optional.of(category)).when(categoryService).findByTitle("other");
        Assertions.assertEquals(product, productService.createNewProduct(productDto));
        Mockito.verify(productRepository, Mockito.times(1)).save(product);
    }

    @Test
    public void filterPrice() {
        Category category = new Category();
        category.setId(1L);
        category.setTitle("other");

        Product product = new Product();
        product.setId(111L);
        product.setPrice(new BigDecimal(120));
        product.setTitle("Apple");
        product.setCategory(category);

        List<Product> products = new ArrayList<>();
        products.add(product);

        Mockito.doReturn(products).when(productRepository).getByPriceGreaterThanEqualAndPriceLessThanEqual(
                new BigDecimal(100), new BigDecimal(150));
        Assertions.assertEquals(products, productService.filterPrice(new BigDecimal(100), new BigDecimal(150)));
    }
}
