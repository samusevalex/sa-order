package ru.iteco.saorder.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.iteco.saorder.api.dto.OrderDto;

@RequestMapping("/api/v1/order")
public interface OrderApi {

    @GetMapping("{id}")
    @ApiOperation(value = "Получить заказ по номеру")
    ResponseEntity<OrderDto> getOrder(@ApiParam(value = "Номер заказа", required = true) @PathVariable("id") long id);

    @PostMapping
    @ApiOperation(value = "Создать заказ")
    ResponseEntity<OrderDto>  createOrder(@RequestBody OrderDto orderDto);

    @PutMapping
    @ApiOperation(value = "Изменить заказ")
    ResponseEntity<OrderDto>  updateOrder(@ApiParam(value = "Номер заказа", required = true) @RequestBody OrderDto orderDto);

    @DeleteMapping("{id}")
    @ApiOperation(value = "Удалить заказ")
    void deleteOrder(@ApiParam(value = "Номер заказа", required = true) @PathVariable("id") long id);
}
