package ru.geekbrains.winter.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.geekbrains.winter.market.api.OrderDto;
import ru.geekbrains.winter.market.api.OrderItemDto;
import ru.geekbrains.winter.market.core.entities.Order;
import ru.geekbrains.winter.market.core.entities.OrderItem;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConverter {
    private final OrderItemConverter orderItemConverter;

    public OrderDto entityToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setAddress(order.getAddress());
        orderDto.setPhone(order.getPhone());
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setUsername(order.getUsername());
        orderDto.setItems(order.getItems().stream().map(orderItemConverter::entityToDto).collect(Collectors.toList()));
        return orderDto;
    }
}
