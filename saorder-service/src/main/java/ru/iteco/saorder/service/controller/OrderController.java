package ru.iteco.saorder.service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.iteco.saorder.api.OrderApi;
import ru.iteco.saorder.api.dto.OrderDto;
import ru.iteco.saorder.service.service.OrderService;

import java.net.URI;


@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<OrderDto> getOrder(long orderId){
        log.info("Получили GET запрос /api/v1/order/{}", orderId);
        OrderDto orderDto = orderService.getOrder(orderId);
        log.info("Отправили ответ: {}", orderDto);
        return ResponseEntity
                .ok(orderDto);
    }

    @Override
    public ResponseEntity<OrderDto> createOrder(OrderDto order){
        log.info("Получили POST запрос /api/v1/order с содержанием {}", order);
        OrderDto orderDto = orderService.createOrder(order);
        log.info("Создали заказ: {}", orderDto);
        return ResponseEntity
                .created(URI.create("/api/v1/order" + orderDto.getId()))
                .body(orderDto);
    }

    @Override
    public ResponseEntity<OrderDto> updateOrder(OrderDto order){
        log.info("Получили PUT запрос /api/v1/order с содержанием {}", order);
        OrderDto orderDto = orderService.updateOrder(order);
        log.info("Изменили заказ: {}", orderDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderDto);
    }

    @Override
    public void deleteOrder(long orderId){
        log.info("Получили DELETE запрос /api/v1/order/{}", orderId);
        orderService.deleteOrder(orderId);
        log.info("Удалили заказ номер {}", orderId);
    }
}
