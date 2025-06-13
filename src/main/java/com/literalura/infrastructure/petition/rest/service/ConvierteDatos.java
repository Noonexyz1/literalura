package com.literalura.infrastructure.petition.rest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvierteDatos {

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T convierteDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
