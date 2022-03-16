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
    private String urlGetProductById;
    public ProductServiceIntegration(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Optional<ProductDto> getProductById(Long id) {
        System.out.println(urlGetProductById);
        return Optional.ofNullable(restTemplate.getForObject(urlGetProductById + id, ProductDto.class));
    }
}
