package com.literalura.infrastructure.persistence.db.utils;

import com.literalura.domain.model.Autor;
import com.literalura.domain.model.Libro;
import com.literalura.infrastructure.persistence.db.entity.AutorEntity;
import com.literalura.infrastructure.persistence.db.entity.LibroEntity;

public class MaperPersistence {

    public static Autor fromAutorEntityToAutor(AutorEntity autorEntity) {
        return new Autor(
                autorEntity.getIdAutor(),
                autorEntity.getNombre(),
                autorEntity.getFechaNace(),
                autorEntity.getFechaFallece(),
                fromLibroEntityToLibro(autorEntity.getIdLibro())
        );
    }

    public static AutorEntity fromAutorToAutorEntity(Autor autor) {
        return new AutorEntity(
                autor.getIdAutor(),
                autor.getNombre(),
                autor.getFechaNace(),
                autor.getFechaFallece(),
                fromLibroToLibroEntity(autor.getLibro())
        );
    }

    //Si se trata de mapea de LibroEntity a Libro, pues el id de este, siempre me vendra con un valor y unico
    public static Libro fromLibroEntityToLibro(LibroEntity libroEntity) {
        //LibroEntity no tiene al camo lista de Autores que tiene Libro, entonces pondre null
        //El comentario anterior, totalmente equivocado, los Mapeardoes deben ser LIMPIOS sin nulls
        return new Libro(
                libroEntity.getIdLibro(),
                libroEntity.getTitulo(),
                libroEntity.getIdioma(),
                libroEntity.getNumDescargas()
        );
    }

    //Si se trata de mapear Entity como Modelos, entonces no tomo en cuenta los List<>
    public static LibroEntity fromLibroToLibroEntity(Libro libro) {
        //Los pongo en null porque esto ya es una clase Entity, esos campos solamente fueron
        //para mapear campos (los campos de relacion).

        //PARA ESTOS MAPEOS NO DEBERIA SETEAR DE NULL, ESO DEBERIA HACERLO EL LA LOGICA DE NEGOCIOS
        //Osea, resolverlo por negocio/programacion, ASI ESTOS MAPEOS SE VEN LIMPIOS :)

        //Establecemos los valores que necesitamos para persistir porque se trata de una ENTITY
        LibroEntity libroEntity = new LibroEntity();
        //Lo hago de esta forma con SETS porque asi tengo mas control con los campos en un metodo
        //ambiente seguro

        libroEntity.setIdLibro(libro.getIdLibro() != null? libro.getIdLibro(): 0);
        libroEntity.setTitulo(libro.getTitulo());
        libroEntity.setIdioma(libro.getIdioma());
        libroEntity.setNumDescargas(libro.getNumDescargas());

        return libroEntity;
    }

}
