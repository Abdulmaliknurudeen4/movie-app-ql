package com.nexusforge.graphqlmovieapp.controller;

import com.nexusforge.graphqlmovieapp.client.MovieClient;
import com.nexusforge.graphqlmovieapp.dto.Customer;
import com.nexusforge.graphqlmovieapp.dto.Genre;
import com.nexusforge.graphqlmovieapp.dto.Movie;
import com.nexusforge.graphqlmovieapp.dto.WatchListResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class MovieController {

    private final MovieClient client;

    public MovieController(MovieClient client) {
        this.client = client;
    }

    @SchemaMapping(typeName = "UserProfile")
    public Flux<Movie> watchList(Customer customer) {
        return this.client.getMoviesByIds(customer.getWatchList());
    }

    @SchemaMapping(typeName = "UserProfile")
    public Flux<Movie> recommended(Customer customer) {
        return this.client.moviesByGenre(customer.getFavoriteGenre());
    }

    @QueryMapping
    public Mono<Movie> movieDetails(@Argument Integer id) {
        return this.client.getMoviesByIds(List.of(id))
                .next();
    }

    @QueryMapping
    public Flux<Movie> moviesByGenre(@Argument Genre genre) {
        return this.client.moviesByGenre(genre);
    }

    @SchemaMapping(typeName = "WatchListResponse")
    public Flux<Movie> watchList(WatchListResponse watchListResponse) {
        return this.client.getMoviesByIds(watchListResponse.getWatchList());
    }
}
