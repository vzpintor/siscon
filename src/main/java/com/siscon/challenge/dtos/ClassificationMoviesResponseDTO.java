package com.siscon.challenge.dtos;

import com.siscon.challenge.entities.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class ClassificationMoviesResponseDTO {
    private int code;
    private Body body;

    public ClassificationMoviesResponseDTO(int code, String classification, List<Movie> movies) {
        this.code = code;
        this.body = new Body(classification, movies);
    }

    @Setter
    @Getter
    public static class Body {
        private String classification;
        private List<MovieSummary> movies;

        public Body(String classification, List<Movie> movies) {
            this.classification = classification;
            this.movies = movies.stream().map(movie -> new MovieSummary(movie.getTitle(), movie.getOriginalTitle(), movie.getOverview())).collect(Collectors.toList());
        }

        @Setter
        @Getter
        public static class MovieSummary {
            private String title;
            private String originalTitle;
            private String overview;

            public MovieSummary(String title, String originalTitle, String overview) {
                this.title = title;
                this.originalTitle = originalTitle;
                this.overview = overview;
            }

        }
    }
}
