package ru.iteco.saorder.service.security;

import ru.iteco.config.security.BusinessOperation;

public enum OrderBusinessOperation implements BusinessOperation {

    ORDER_CREATE("Создание заказа"),
    ORDER_GET("Просмотр заказа"),
    ORDER_UPDATE("Обновление заказа"),
    ORDER_DELETE("Удаление заказа");

    private final String description;

    OrderBusinessOperation(String description) {
        this.description = description;
    }
}
