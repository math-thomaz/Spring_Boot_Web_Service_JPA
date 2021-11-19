package com.maththomaz.webService.services;

import com.maththomaz.webService.entities.Order;
import com.maththomaz.webService.entities.User;
import com.maththomaz.webService.repositories.OrderRepository;
import com.maththomaz.webService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj =  orderRepository.findById(id);
        return obj.get();
    }
}
