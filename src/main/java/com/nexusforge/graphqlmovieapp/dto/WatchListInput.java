package com.nexusforge.graphqlmovieapp.dto;

import lombok.Data;

@Data
public class WatchListInput {
    private Integer customerId;
    private Integer movieId;
}
