package ru.iteco.saorder.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.iteco.saorder.api.dto.OrderDto;
import ru.iteco.saorder.service.model.OrderStatus;
import ru.iteco.saorder.service.model.Orders;
import ru.iteco.saorder.service.repository.OrdersRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderService implements IOrderService {

    private final OrdersRepository ordersRepository;
    private final MapperFacade mapperFacade;

    @Override
    public OrderDto getOrder(long orderId) {
        Optional<Orders> optionalOrderEntity = ordersRepository.findById(orderId);
        if (optionalOrderEntity.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Orders orderEntity = optionalOrderEntity.get();
        return mapperFacade.map(orderEntity, OrderDto.class);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Orders orderEntity = mapperFacade.map(orderDto, Orders.class);
        orderEntity.setStatus(OrderStatus.CREATED);
        Orders returnOrderEntity = ordersRepository.save(orderEntity);
        return mapperFacade.map(returnOrderEntity, OrderDto.class);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        long orderId = orderDto.getId();
        Optional<Orders> optionalOrderEntity = ordersRepository.findById(orderId);
        if (optionalOrderEntity.isEmpty()) {
            throw new EntityNotFoundException("Entity " + orderId + " not found");
        }
        Orders orderEntity = optionalOrderEntity.get();
        mapperFacade.map(orderDto, orderEntity);
        Orders returnOrderEntity = ordersRepository.save(orderEntity);
        return mapperFacade.map(returnOrderEntity, OrderDto.class);
    }

    @Override
    public void deleteOrder(long orderId) {
        ordersRepository.deleteById(orderId);
    }
}