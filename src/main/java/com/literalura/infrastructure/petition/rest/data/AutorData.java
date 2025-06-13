package com.literalura.infrastructure.petition.rest.data;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorData(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Long fechaNace,
        @JsonAlias("death_year") Long fechaFallece
) {
}
