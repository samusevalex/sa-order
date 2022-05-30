package ru.iteco.saorder.service.config;

import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Configuration;
import ru.iteco.saorder.api.dto.OrderDto;
import ru.iteco.saorder.service.model.Orders;

@Configuration
public class MapperConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(Orders.class, OrderDto.class)
                .byDefault()
                .register();
    }
}