package com.nexusforge.graphqlmovieapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
//not included. just incase to send id??
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerInput {
    private Integer id;
    private String name;
    private Genre favoriteGenre;
}
