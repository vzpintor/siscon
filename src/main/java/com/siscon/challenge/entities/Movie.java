package com.siscon.challenge.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "movie")
public class Movie {
    @Id
    private Integer id;
    private String title;
    private String originalTitle;

    @Column(columnDefinition = "text")
    private String overview;
    private String genreIds;
}
