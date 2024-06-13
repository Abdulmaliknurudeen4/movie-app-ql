package com.nexusforge.graphqlmovieapp.controller;

import com.nexusforge.graphqlmovieapp.client.MovieClient;
import com.nexusforge.graphqlmovieapp.dto.Customer;
import com.nexusforge.graphqlmovieapp.dto.Movie;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class MovieController {

    private final MovieClient client;

    public MovieController(MovieClient client) {
        this.client = client;
    }

    @SchemaMapping(typeName = "UserProfile")
    public Flux<Movie> watchList(Customer customer) {
        return this.client.getMoviesById(customer.getWatchList());
    }

    @SchemaMapping(typeName = "UserProfile")
    public Flux<Movie> recommended(Customer customer) {
        return this.client.moviesByGenre(customer.getFavoriteGenre());
    }
}
