package com.literalura.infrastructure.persistence.db.adapter;

import com.literalura.application.port.out.persistence.LibroAbs;
import com.literalura.domain.model.Libro;
import com.literalura.infrastructure.persistence.db.entity.LibroEntity;
import com.literalura.infrastructure.persistence.db.service.LibroRepository;
import com.literalura.infrastructure.persistence.db.utils.MaperPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibroAdapter implements LibroAbs {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public Libro resgistrarLibro(Libro libro) {
        LibroEntity libroEntity = libroRepository
                .save(MaperPersistence.fromLibroToLibroEntitity(libro));
        return MaperPersistence.fromLibroEntityToLibro(libroEntity);
    }

    @Override
    public List<Libro> listarLibros() {
        return libroRepository.findAll().stream()
                .map(MaperPersistence::fromLibroEntityToLibro)
                .toList();
    }

    @Override
    public List<Libro> listarLibros(String codigoIdioma) {
        //TODO, litar libros por columna codigo de idioma
        return libroRepository.findAll().stream()
                .map(MaperPersistence::fromLibroEntityToLibro)
                .toList();
    }
}
