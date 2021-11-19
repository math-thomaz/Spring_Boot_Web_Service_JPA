package com.maththomaz.webService.repositories;

import com.maththomaz.webService.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
