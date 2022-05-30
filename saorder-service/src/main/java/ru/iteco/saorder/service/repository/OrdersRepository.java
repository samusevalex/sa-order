package ru.iteco.saorder.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.iteco.saorder.service.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
