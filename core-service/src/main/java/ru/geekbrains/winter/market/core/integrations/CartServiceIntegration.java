package ru.geekbrains.winter.market.core.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.winter.market.api.CartDto;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final RestTemplate restTemplate;

    @Value("${url.clear}")
    private String urlClear;

    public void clear() {
        restTemplate.getForEntity(urlClear,Void.class);
    }

    @Value("${url.getCurrentCart}")
    private String urlGetCurrentCart;

    public CartDto getCurrentCart() {
        return restTemplate.getForObject(urlGetCurrentCart, CartDto.class);
    }
}
