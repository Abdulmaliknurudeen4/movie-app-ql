package com.nexusforge.graphqlmovieapp.controller;

import com.nexusforge.graphqlmovieapp.client.CustomerClient;
import com.nexusforge.graphqlmovieapp.dto.Customer;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {
    private final CustomerClient client;

    public CustomerController(CustomerClient client) {
        this.client = client;
    }

    @QueryMapping
    public Mono<Customer> userProfile(@Argument Integer id) {
        return this.client.getCustomer(id);
    }

}
