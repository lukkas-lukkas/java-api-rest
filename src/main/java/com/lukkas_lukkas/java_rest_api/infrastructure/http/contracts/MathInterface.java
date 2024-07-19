package com.lukkas_lukkas.java_rest_api.infrastructure.http.contracts;

import com.lukkas_lukkas.java_rest_api.application.math.MathResponse;
import com.lukkas_lukkas.java_rest_api.domain.exceptions.ValidationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "general")
public interface MathInterface {

    @Operation(
            summary = "Math operations",
            description = "Make simple math operations between two values",
            method = "POST",
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = "operation",
                            description = "Math operation to perform",
                            required = true,
                            schema = @Schema(
                                    type = "string",
                                    allowableValues = {
                                            "SUM",
                                            "SUB",
                                            "DIV",
                                            "MULT",
                                    }
                            )
                    ),
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = "numberOne",
                            //description = "Math operation to perform",
                            required = true,
                            schema = @Schema(
                                    type = "integer"
                            )
                    ),
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = "numberTwo",
                            //description = "Math operation to perform",
                            required = true,
                            schema = @Schema(
                                    type = "integer"
                            )
                    )
            }
    )
    @ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Calculation completed successfully",
                content = {@Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = MathResponse.class)
                )}
        ),
        @ApiResponse(
                responseCode = "422",
                description = "Data validation error",
                content = {@Content(
                        mediaType = "application/json",
                        array = @ArraySchema(schema = @Schema(implementation = String.class)),
                        examples = {
                                @ExampleObject(
                                        value = "[\"Invalid math operation\", \"Another error\"]"
                                )
                        }
                )}
        )
    })
    public ResponseEntity<MathResponse> math(
            String operation,
            String numberOne,
            String numberTwo
    ) throws ValidationException;
}
