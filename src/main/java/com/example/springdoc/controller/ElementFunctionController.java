package com.example.springdoc.controller;

import com.example.springdoc.model.Element;
import com.example.springdoc.service.ElementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
@Tag(name = "Element Function Controller", description = "Service for creating and retrieving elements using functions")
public class ElementFunctionController {

    private final ElementService elementService;

    @Bean
    @RouterOperation(operation = @Operation(description = "Create element", operationId = "createElement", tags = "element",
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Element.class)))))
    public Function<String, Element> createElement() {
        return elementService::createElement;
    }

    @Bean
    @RouterOperation(operation = @Operation(description = "Get element", operationId = "getElement", tags = "element",
            parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "id")},
            responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Element.class)))))
    public Function<Long, Element> getElement() {
        return elementService::getElement;
    }

    @Bean
    @RouterOperation(operation = @Operation(description = "Get elements", operationId = "getElements", tags = "element",
            responses = @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Element.class))))))
    public Supplier<List<Element>> getElements() {
        return elementService::getElements;
    }
}
