package com.siscon.challenge.rest;

import com.siscon.challenge.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Operation(summary = "Fetch and save popular movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Popular movies fetched and saved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/fetch-popular-movies")
    public String fetchPopularMovies() {
        movieService.fetchAndSavePopularMovies();
        return "Popular movies fetched and saved successfully!";
    }
}