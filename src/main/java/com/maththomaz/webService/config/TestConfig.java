package com.maththomaz.webService.config;

import com.maththomaz.webService.entities.Category;
import com.maththomaz.webService.entities.Order;
import com.maththomaz.webService.entities.User;
import com.maththomaz.webService.entities.enums.OrderStatus;
import com.maththomaz.webService.repositories.CategoryRepository;
import com.maththomaz.webService.repositories.OrderRepository;
import com.maththomaz.webService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = User.builder()
                .name("Maria Brown")
                .email("maria@gmail.com")
                .phone("999999999")
                .password("123456")
                .build();

        User u2 = User.builder()
                .name("Carl Wild")
                .email("carl@gmail.com")
                .phone("988888888")
                .password("654321")
                .build();

        Order o1 = Order.builder()
                .moment(Instant.parse("2021-06-21T19:53:07Z"))
                .orderStatus(2)
                .client(u1)
                .build();

        Order o2 = Order.builder()
                .moment(Instant.parse("2021-07-21T03:42:10Z"))
                .orderStatus(1)
                .client(u2)
                .build();

        Category c1 = Category.builder()
                .name("Electronics")
                .build();

        Category c2 = Category.builder()
                .name("Books")
                .build();

        Category c3 = Category.builder()
                .name("Computer")
                .build();

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}
