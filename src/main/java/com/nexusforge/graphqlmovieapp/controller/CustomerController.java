package com.nexusforge.graphqlmovieapp.controller;

import com.nexusforge.graphqlmovieapp.client.CustomerClient;
import com.nexusforge.graphqlmovieapp.dto.*;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.Collections;

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

    @MutationMapping
    public Mono<Customer> updateProfile(@Argument CustomerInput input) {
        return this.client.updateCustomer(input);
    }

    @MutationMapping
    public Mono<WatchListResponse> addToWatchList(@Argument WatchListInput input){
        return this.client.addToWatchList(input)
                .map(list -> WatchListResponse.create(Status.SUCCESS, list))
                .onErrorReturn(WatchListResponse.create(Status.FAILURE, Collections.emptyList()));
    }

}
