package com.nexusforge.graphqlmovieapp.controller;

import com.nexusforge.graphqlmovieapp.client.ReviewClient;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewController {
    private final ReviewClient client;

    public ReviewController(ReviewClient client) {
        this.client = client;
    }
}
