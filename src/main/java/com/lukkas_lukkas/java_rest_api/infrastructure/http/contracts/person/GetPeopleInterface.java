package com.lukkas_lukkas.java_rest_api.infrastructure.http.contracts.person;

import com.lukkas_lukkas.java_rest_api.infrastructure.http.presenters.PersonView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Tag(name = "Person")
public interface GetPeopleInterface {

    @Operation(
            summary = "List of person",
            description = "Get a list of person",
            method = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "List retrieved",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PersonView[].class)
                    )}
            )
    })
    public ResponseEntity<List<PersonView>> get();
}
