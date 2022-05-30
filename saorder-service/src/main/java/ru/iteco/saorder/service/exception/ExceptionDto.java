package ru.iteco.saorder.service.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class ExceptionDto {
    private UUID uuid;
    private String message;

}
