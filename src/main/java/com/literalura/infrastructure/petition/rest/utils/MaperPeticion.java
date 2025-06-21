package com.literalura.infrastructure.petition.rest.utils;

import com.literalura.domain.model.Libro;
import com.literalura.infrastructure.petition.rest.data.LibroData;

public class MaperPeticion {

    public static Libro fromLibroDataToLibro(LibroData libroData) {
        //Aqui debo mapear los modelos de datos segun requerimineto, observar esto,
        // libroData.idioma().toString(), se entiende?
        return new Libro(
                libroData.idLibro(),
                libroData.titulo(),
                libroData.idioma().toString(),
                libroData.numDescargas()
        );
    }
}
