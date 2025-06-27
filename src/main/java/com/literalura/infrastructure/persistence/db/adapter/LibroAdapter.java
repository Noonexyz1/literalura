package com.literalura.infrastructure.persistence.db.adapter;

import com.literalura.application.port.out.persistence.LibroAbs;
import com.literalura.domain.model.Libro;
import com.literalura.infrastructure.persistence.db.entity.LibroEntity;
import com.literalura.infrastructure.persistence.db.exception.LibroPorTituloException;
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
        LibroEntity libroEntityToSave = MaperPersistence.fromLibroToLibroEntity(libro);

        //Si se trata de registrar un nuevo libro, entonces el ID deberia ser NULL
        libroEntityToSave.setIdLibro(null);

        LibroEntity libroEntity = libroRepository.save(libroEntityToSave);
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
        return libroRepository.findByIdioma(codigoIdioma).stream()
                .map(MaperPersistence::fromLibroEntityToLibro)
                .toList();
    }

    @Override
    public Libro buscarLibroPorTitulo(String titulo) {
        LibroEntity libro = this.libroRepository.findByTitulo(titulo);
        if (libro == null) {
            //Retornamos un objeto por defecto Libro PseudoNull con valores
            //extremadamente rididulos definodo por dominio o que la empresa me haya
            // dicho que esto nunca sera un libro y todos estemos de acuerdo.
            // o reemplazar los valores con un ENUM jajajaja para luego cambiarlos a placer
            return new Libro(
                    -1L,
                    "",
                    "",
                    -0.0
            );
        }
        return MaperPersistence.fromLibroEntityToLibro(libro);
    }
}
