package ru.iteco.saorder.service.config;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "swagger")
@Getter
@Setter
@ToString
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class SwaggerProperties {

    /**
     * Название проекта
     */
    String title;

    /**
     * Описание
     */
    String description;

    /**
     * Контактное лицо
     */
    Contact contract = new Contact();

    @Getter
    @Setter
    @ToString
    @Accessors(chain = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Contact {

        String name;

        String url;

        String mail;

    }
}