package com.example.springdoc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@NoArgsConstructor
public class Element {

    private static final AtomicLong ID_GEN = new AtomicLong(1L);

    public Element(String name) {
        this.id = ID_GEN.getAndIncrement();
        this.name = name;
    }

    private Long id;
    private String name;
}
