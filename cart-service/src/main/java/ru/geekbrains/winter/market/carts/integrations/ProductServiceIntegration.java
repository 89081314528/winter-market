package ru.geekbrains.winter.market.carts.integrations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.winter.market.api.ProductDto;

import java.util.Optional;

@Component
public class ProductServiceIntegration {
    private final RestTemplate restTemplate;

    @Value("${url.getProductById}")
//    private String urlGetProductById = getProductById(null).toString(); // можно вызвать метод, который что то возвращает
    // sout вызвать нельзя
    // можно создать поле, инициализировать его, объявить метод
    // вызвать метод можно только в анонимном блоке инициализации
    private String urlGetProductById;
//    {
//        System.out.println(urlGetProductById); // анонимный блок инициализации, редко используется
//    }
    public ProductServiceIntegration(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<ProductDto> getProductById(Long id) {
//        return Optional.ofNullable(restTemplate.getForObject("http://localhost:8189/winter/api/v1/products/" + id, ProductDto.class));
        System.out.println("orange");
        System.out.println(urlGetProductById);
        return Optional.ofNullable(restTemplate.getForObject(urlGetProductById + id, ProductDto.class));
    }
}
