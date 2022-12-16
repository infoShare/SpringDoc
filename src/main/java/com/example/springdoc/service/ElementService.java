package com.example.springdoc.service;

import com.example.springdoc.model.Element;
import com.example.springdoc.repository.ElementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElementService {

    private final ElementRepository elementRepository;

    public Element createElement(String name) {
        return elementRepository.save(new Element(name));
    }

    public Element getElement(Long id) {
        return elementRepository.findById(id);
    }

    public List<Element> getElements() {
        return elementRepository.findAll();
    }
}
