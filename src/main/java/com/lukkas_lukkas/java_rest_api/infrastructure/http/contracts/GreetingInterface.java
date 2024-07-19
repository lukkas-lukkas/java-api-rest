package com.lukkas_lukkas.java_rest_api.infrastructure.http.contracts;

import com.lukkas_lukkas.java_rest_api.domain.Greeting;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "General")
public interface GreetingInterface {

    @Operation(
            summary = "Make a greeting",
            description = "Receive a greeting with a default value or your name",
            method = "GET"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Greeting created successfully",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Greeting.class)
            )}
    )
    public Greeting greeting(String name);
}
