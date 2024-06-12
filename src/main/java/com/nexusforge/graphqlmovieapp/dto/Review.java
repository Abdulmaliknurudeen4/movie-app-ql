package com.nexusforge.graphqlmovieapp.dto;

import lombok.Data;

@Data
public class Review {

    private Integer id;
    private String username;
    private Integer rating;
    private String comment;

}
