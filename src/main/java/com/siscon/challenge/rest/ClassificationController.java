package com.siscon.challenge.rest;

import com.siscon.challenge.services.ClassificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @Operation(summary = "Fetch and save movie classifications")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classifications fetched and saved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/fetch-classifications")
    public String fetchClassifications() {
        classificationService.fetchAndSaveClassifications();
        return "Classifications fetched and saved successfully!";
    }

}