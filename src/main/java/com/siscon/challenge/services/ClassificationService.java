package com.siscon.challenge.services;

import com.siscon.challenge.dtos.GenreResponseDTO;
import com.siscon.challenge.repository.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClassificationService {

    @Autowired
    private ClassificationRepository classificationRepository;

    private final String apiUrl = "https://api.themoviedb.org/3/genre/movie/list?language=es&api_key=9fd5e4a33d7455ab07559eee33dc09fe";

    public void fetchAndSaveClassifications() {
        RestTemplate restTemplate = new RestTemplate();
        GenreResponseDTO response = restTemplate.getForObject(apiUrl, GenreResponseDTO.class);
        if (response != null && response.getGenres() != null) {
            classificationRepository.saveAll(response.getGenres());
        }
    }
}
