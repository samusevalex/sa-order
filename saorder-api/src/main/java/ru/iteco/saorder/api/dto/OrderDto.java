package ru.iteco.saorder.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class OrderDto {

    @ApiModelProperty(value = "ID заказа", example = "123456789")
    private Long id;

    @ApiModelProperty(value = "Дата исполнения", example = "30-12-2020", required = true)
    private LocalDate completeAt;

    @ApiModelProperty(value = "Статус заказа", example = "MODIFIED")
    private String status;

    @ApiModelProperty(value = "Идентификатор клиента", example = "123456789", required = true)
    private UUID clientId;

    @ApiModelProperty(value = "Список идентификаторов услуг", required = true)
    private Set<Long> features;

    @ApiModelProperty(value = "Идентификатор договора ", example = "123456789")
    private UUID contractId;

    @ApiModelProperty(value = "Идентификатор сотрудника", example = "123456789", required = true)
    private long employeeId;
}
