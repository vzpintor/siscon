package com.siscon.challenge.services;

import com.siscon.challenge.dtos.MovieResponseDTO;
import com.siscon.challenge.dtos.MovieResultDTO;
import com.siscon.challenge.entities.Movie;
import com.siscon.challenge.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private final String apiUrl = "https://api.themoviedb.org/3/trending/movie/week?language=es&api_key=9fd5e4a33d7455ab07559eee33dc09fe";

    public void fetchAndSavePopularMovies() {
        RestTemplate restTemplate = new RestTemplate();
        for (int page = 1; page <= 5; page++) {
            String paginatedUrl = apiUrl + "&page=" + page;
            MovieResponseDTO response = restTemplate.getForObject(paginatedUrl, MovieResponseDTO.class);
            if (response != null && response.getResults() != null) {
                for (MovieResultDTO result : response.getResults()) {
                    Movie movie = new Movie();
                    movie.setId(result.getId());
                    movie.setTitle(result.getTitle());
                    movie.setOriginalTitle(result.getOriginal_title());
                    movie.setOverview(result.getOverview());
                    movie.setGenreIds(result.getGenre_ids().stream().map(String::valueOf).collect(Collectors.joining(",")));

                    movieRepository.save(movie);
                }
            }
        }
    }
}