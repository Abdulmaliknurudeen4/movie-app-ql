package com.nexusforge.graphqlmovieapp.client;

import com.nexusforge.graphqlmovieapp.dto.Genre;
import com.nexusforge.graphqlmovieapp.dto.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class MovieClient {
    private final WebClient client;

    public MovieClient(@Value("${movie.service.url}") String baseUrl) {
        this.client = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public Flux<Movie> moviesByGenre(Genre genre) {
        return this.client.get()
                .uri("{genre}/recommended", genre)
                .retrieve()
                .bodyToFlux(Movie.class);

    }

    private Flux<Movie> moviesById(List<Integer> ids) {
        return this.client.get()
                .uri(b -> b.queryParam("ids", ids).build())
                .retrieve()
                .bodyToFlux(Movie.class);

    }

    public Flux<Movie> getMoviesByIds(List<Integer> ids) {
        //in case moviesrecommned is null, sends empty list
        return ids.isEmpty() ? Flux.empty() : moviesById(ids);
    }
}
