package com.example.springdoc.repository;

import com.example.springdoc.model.Element;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ElementRepository {
    private final Map<Long, Element> database = new ConcurrentHashMap<>();

    public List<Element> findAll() {
        return database.values().stream().sorted().toList();
    }

    public Element save(Element element) {
        database.put(element.getId(), element);
        return element;
    }

    public Element findById(Long id) {
        return database.get(id);
    }
}
