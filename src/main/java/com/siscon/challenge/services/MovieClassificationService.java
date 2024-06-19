package com.siscon.challenge.services;

import com.siscon.challenge.dtos.ClassificationMoviesResponseDTO;
import com.siscon.challenge.entities.Classification;
import com.siscon.challenge.entities.Movie;
import com.siscon.challenge.repository.ClassificationRepository;
import com.siscon.challenge.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieClassificationService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ClassificationRepository classificationRepository;

    public ClassificationMoviesResponseDTO getMoviesByClassification(int classificationId) {
        Optional<Classification> classificationOpt = classificationRepository.findById(classificationId);
        if (classificationOpt.isPresent()) {
            Classification classification = classificationOpt.get();
            List<Movie> movies = movieRepository.findByGenreIdsContaining(String.valueOf(classification.getId()));
            return new ClassificationMoviesResponseDTO(200, classification.getName(), movies);
        } else {
            return new ClassificationMoviesResponseDTO(404, "Classification not found", null);
        }
    }

}
