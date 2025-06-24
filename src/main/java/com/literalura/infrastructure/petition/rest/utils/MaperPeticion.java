package com.literalura.infrastructure.petition.rest.utils;

import com.literalura.domain.model.Autor;
import com.literalura.domain.model.Libro;
import com.literalura.infrastructure.petition.rest.data.AutorData;
import com.literalura.infrastructure.petition.rest.data.LibroData;

public class MaperPeticion {

    public static Libro fromLibroDataToLibro(LibroData libroData) {
        //Aqui debo mapear los modelos de datos segun requerimiento, observar esto,
        // libroData.idioma().toString(), se entiende?
        return new Libro(
                libroData.idLibro(),
                libroData.titulo(),

                //Debo tener mucho cuidado con esto, porque en el dominio este campo es String
                //Y lo que me viene de la API es una Lista de String, en este caso idiomas
                libroData.idioma().toString(),

                libroData.numDescargas()
        );
    }

    public static Autor fromAutorDataToAutor(AutorData autorData) {
        Autor autor = new Autor();
        autor.setNombre(autorData.nombre());
        autor.setFechaNace(autorData.fechaNace());
        autor.setFechaFallece(autorData.fechaFallece());
        return autor;
    }
}
