package com.lukkas_lukkas.java_rest_api.infrastructure.http.contracts.person;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Person")
public interface DeletePersonInterface {

    @Operation(
            summary = "Delete a person",
            description = "Delete a person resource",
            method = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Person deleted successfully",
                    content = {@Content(
                            mediaType = "application/json"
                    )}
            )
    })
    public ResponseEntity<?> delete(String id);
}
