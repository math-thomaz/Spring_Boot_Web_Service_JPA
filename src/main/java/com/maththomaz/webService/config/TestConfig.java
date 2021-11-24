package com.maththomaz.webService.config;

import com.maththomaz.webService.entities.*;
import com.maththomaz.webService.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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

        Product p1 = Product.builder()
                .name("The Lord of the Rings")
                .description("Lorem ipsum dolor sit amet, consectetur.")
                .price(20.5)
                .imgUrl("imgurl.com/random_address1")
                .categories(Collections.singleton(c2))
                .build();

        Product p2 = Product.builder()
                .name("Smart TV")
                .description("Nulla eu imperdiet purus. Maecenas ante.")
                .price(1190.0)
                .imgUrl("imgurl.com/random_address2")
                .categories(Collections.singleton(c3))
                .build();

        Product p3 = Product.builder()
                .name("Macbook Pro")
                .description("Nam eleifend maximus tortor, at mollis.")
                .price(1250.0)
                .imgUrl("imgurl.com/random_address3")
                .categories(Collections.singleton(c3))
                .build();

        Product p4 = Product.builder()
                .name("PC Gamer")
                .description("Donec aliquet odio ac rhoncus cursus.")
                .price(1200.0)
                .imgUrl("imgurl.com/random_address4")
                .categories(Collections.singleton(c3))
                .build();

        Product p5 = Product.builder()
                .name("Rails for Dummies")
                .description("Cras fringilla convallis sem vel faucibus.")
                .price(19.9)
                .imgUrl("imgurl.com/random_address5")
                .categories(Collections.singleton(c2))
                .build();

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o2, p5, 2, p5.getPrice());

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2021-06-21T21:53:07Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);
    }
}
