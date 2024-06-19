package com.siscon.challenge.rest;

import com.siscon.challenge.dtos.ClassificationMoviesResponseDTO;
import com.siscon.challenge.services.MovieClassificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieClassificationController {

    @Autowired
    private MovieClassificationService movieClassificationService;


    @Operation(summary = "Get movies by classification ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the movies"),
            @ApiResponse(responseCode = "404", description = "Classification not found")
    })
    @GetMapping("/movies-by-classification/{classificationId}")
    public ClassificationMoviesResponseDTO getMoviesByClassification(@PathVariable int classificationId) {
        return movieClassificationService.getMoviesByClassification(classificationId);
    }
}