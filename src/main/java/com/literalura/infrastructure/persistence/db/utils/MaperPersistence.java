package com.literalura.infrastructure.persistence.db.utils;

import com.literalura.domain.model.Autor;
import com.literalura.domain.model.Libro;
import com.literalura.infrastructure.persistence.db.entity.AutorEntity;
import com.literalura.infrastructure.persistence.db.entity.LibroEntity;

//TODO, hacer todos los mapeos
public class MaperPersistence {

    public static Autor fromAutorEntitityToAutor(AutorEntity autorEntity) {
        return new Autor();
    }

    public static AutorEntity fromAutorToAutorEntitity(Autor autor) {
        return new AutorEntity();
    }

    public static Libro fromLibroEntityToLibro(LibroEntity libroEntity) {
        return new Libro(
                libroEntity.getIdLibro(),
                libroEntity.getTitulo(),
                libroEntity.getIdioma(),
                libroEntity.getNumDescargas()
        );
    }

    public static LibroEntity fromLibroToLibroEntitity(Libro libro) {
        //Los pongo en null porque esto ya es una clase Entity, esos campos solamente fueron
        //para mapear campos (los campos de relacion).
        return new LibroEntity(
                null,
                libro.getTitulo(),
                libro.getIdioma(),
                libro.getNumDescargas(),
                null
        );
    }
}
