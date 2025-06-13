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
        return new Libro();
    }

    public static LibroEntity fromLibroToLibroEntitity(Libro libro) {
        return new LibroEntity();
    }
}
