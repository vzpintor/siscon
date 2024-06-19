package com.siscon.challenge.dtos;

import com.siscon.challenge.entities.Classification;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenreResponseDTO {

    private List<Classification> genres;

}
