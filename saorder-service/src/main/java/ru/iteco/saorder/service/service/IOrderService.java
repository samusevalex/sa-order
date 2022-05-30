package ru.iteco.saorder.service.service;

import org.springframework.security.access.prepost.PreAuthorize;
import ru.iteco.saorder.api.dto.OrderDto;

public interface IOrderService {
    /**
     * Получение заказа по id
     * @param orderId
     * @return
     */
    @PreAuthorize("hasPermission(T(ru.iteco.saorder.service.security.OrderBusinessOperation).ORDER_GET, \"Вы не можете просматривать информацию о заказах\")")
    OrderDto getOrder(long orderId);

    /**
     * Создание заказа
     * @param orderDto
     * @return
     */
    @PreAuthorize("hasPermission(T(ru.iteco.saorder.service.security.OrderBusinessOperation).ORDER_CREATE, \"Вы не можете создавать заказы\")")
    OrderDto createOrder(OrderDto orderDto);

    /**
     * Обновление заказа
     * @param orderDto
     * @return
     */
    @PreAuthorize("hasPermission(T(ru.iteco.saorder.service.security.OrderBusinessOperation).ORDER_UPDATE, \"Вы не можете обновлять заказы\")")
    OrderDto updateOrder(OrderDto orderDto);

    /**
     * Удаление заказа
     * @param orderId
     */
    @PreAuthorize("hasPermission(T(ru.iteco.saorder.service.security.OrderBusinessOperation).ORDER_DELETE, \"Вы не можете удалять заказы\")")
    void deleteOrder(long orderId);
}
