package com.lukkas_lukkas.java_rest_api.infrastructure.http.contracts.person;

import com.lukkas_lukkas.java_rest_api.infrastructure.http.forms.person.UpdatePersonForm;
import com.lukkas_lukkas.java_rest_api.infrastructure.http.presenters.PersonView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Tag(name = "Person")
public interface UpdatePersonInterface {

    @Operation(
            summary = "Update person",
            description = "Update a person, full or partially",
            method = "PATCH"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Person updated",
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
    public ResponseEntity<PersonView> update(UpdatePersonForm body, String id);
}
