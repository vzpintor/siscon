package com.siscon.challenge.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieResponseDTO {

    private int page;
    private List<MovieResultDTO> results;
}
