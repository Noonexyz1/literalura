package com.literalura.infrastructure.persistence.db.utils;

import com.literalura.domain.model.Autor;
import com.literalura.domain.model.Libro;
import com.literalura.infrastructure.persistence.db.entity.AutorEntity;
import com.literalura.infrastructure.persistence.db.entity.LibroEntity;

public class MaperPersistence {

    public static Autor fromAutorEntitityToAutor(AutorEntity autorEntity) {
        return new Autor(
                autorEntity.getIdAutor(),
                autorEntity.getNombre(),
                autorEntity.getFechaNace().toString(),
                autorEntity.getFechaFallece().toString(),
                autorEntity.getIdLibro().getIdLibro()
        );
    }

    public static AutorEntity fromAutorToAutorEntitity(Autor autor) {
        LibroEntity libroEntity = new LibroEntity();
        libroEntity.setIdLibro(autor.getIdLibro());

        return new AutorEntity(
                autor.getIdAutor(),
                autor.getNombre(),
                Long.valueOf(autor.getFechaNace()),
                Long.valueOf(autor.getFechaFallece()),
                libroEntity
        );
    }

    public static Libro fromLibroEntityToLibro(LibroEntity libroEntity) {
        //LibroEntity no tiene al camo lista de Autores que tiene Libro, entonces pondre null
        return new Libro(
                libroEntity.getIdLibro(),
                libroEntity.getTitulo(),
                libroEntity.getIdioma(),
                libroEntity.getNumDescargas(),
                null
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
