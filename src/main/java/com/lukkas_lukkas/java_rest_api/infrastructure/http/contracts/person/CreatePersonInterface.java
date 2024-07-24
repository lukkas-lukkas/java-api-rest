package com.lukkas_lukkas.java_rest_api.infrastructure.http.contracts.person;

import com.lukkas_lukkas.java_rest_api.infrastructure.http.forms.person.CreatePersonForm;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.presenters.PersonView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Tag(name = "Person")
public interface CreatePersonInterface {

    @Operation(
            summary = "Create a person",
            description = "Create a person resource",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Person created successfully",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PersonView.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Data validation error",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    type = "object",
                                    implementation = Map.class
                            ),
                            examples = {
                                    @ExampleObject(
                                            value = "{\"name\": \"Invalid name\", \"email\": \"Invalid email\"}"
                                    )
                            }
                    )}
            )
    })
    public ResponseEntity<PersonView> create(CreatePersonForm form);
}
