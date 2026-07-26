package com.tutorials.sid.spring.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

/**
 * @author kunmu On 26-07-2026
 */
@Service
public class OrderConsumer implements Consumer<String> {
    @Override
    public void accept(String order) {
        System.out.println("Order received: " + order);
    }
}
