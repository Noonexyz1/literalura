package com.literalura.infrastructure.petition.rest.data;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultData(
        @JsonAlias("results") List<LibroData> listaLibros
) {
}
