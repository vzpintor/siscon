package com.siscon.challenge.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieResultDTO {

    private int id;
    private String title;
    private String original_title;
    private String overview;
    private List<Integer> genre_ids;

}
