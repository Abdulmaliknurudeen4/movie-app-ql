package com.nexusforge.graphqlmovieapp.controller;

import com.nexusforge.graphqlmovieapp.client.ReviewClient;
import com.nexusforge.graphqlmovieapp.dto.Movie;
import com.nexusforge.graphqlmovieapp.dto.Review;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class ReviewController {
    private final ReviewClient client;

    public ReviewController(ReviewClient client) {
        this.client = client;
    }

    @SchemaMapping(typeName = "MovieDetails")
    public Flux<Review> reviews(Movie movie) {
        return this.client.reviews(movie.getId());
    }
}
