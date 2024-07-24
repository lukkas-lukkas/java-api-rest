package com.lukkas_lukkas.java_rest_api.infrastructure.http.contracts.person;

import com.lukkas_lukkas.java_rest_api.infrastructure.http.presenters.PersonView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Person")
public interface GetPersonInterface {

    @Operation(
            summary = "Get person by ID",
            description = "Get a specific person by ID",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Person found",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PersonView.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Person not found",
                    content = {@Content(
                            mediaType = "application/json"
                    )}
            )
    })
    public ResponseEntity<PersonView> get(String id);
}
