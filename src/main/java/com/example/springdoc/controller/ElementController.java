package com.example.springdoc.controller;

import com.example.springdoc.model.Element;
import com.example.springdoc.service.ElementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "Element Controller", description = "Service for creating and retrieving elements")
public class ElementController {

    private final ElementService elementService;

    @PostMapping("/element")
    @Operation(summary = "Create element")
    @ApiResponse(responseCode = "200", description = "Successfully created element")
    public Element createElement(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Element name", required = true)
                                 @RequestBody String name) {
        return elementService.createElement(name);
    }

    @GetMapping("/element/{id}")
    @Operation(summary = "Retrieve element by id")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved element")
    @ApiResponse(responseCode = "404", description = "Element does not exist")
    public Element getElement(@Parameter(name = "id", description = "id", required = true) @PathVariable Long id) {
        return elementService.getElement(id);
    }

    @GetMapping("/elements")
    @Operation(summary = "Retrieve all elements")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved elements")
    public List<Element> getElements() {
        return elementService.getElements();
    }
}
