package com.literalura.infrastructure.persistence.db.adapter;

import com.literalura.application.port.out.persistence.AutorAbs;
import com.literalura.domain.model.Autor;
import com.literalura.domain.model.Libro;
import com.literalura.infrastructure.persistence.db.entity.AutorEntity;
import com.literalura.infrastructure.persistence.db.entity.LibroEntity;
import com.literalura.infrastructure.persistence.db.service.AutorRepository;
import com.literalura.infrastructure.persistence.db.utils.MaperPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutorAdapter implements AutorAbs {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> listarAutores() {
        return autorRepository.findAll().stream()
                .map(MaperPersistence::fromAutorEntityToAutor)
                .toList();
    }

    @Override
    public List<Autor> listarAutoresVivos(int anio) {
        return autorRepository.listarAutoresVivos(anio).stream()
                .map(MaperPersistence::fromAutorEntityToAutor)
                .toList();
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        AutorEntity autorToSave = MaperPersistence.fromAutorToAutorEntity(autor);
        // autorToSave se va ha mutar por jpa despues de hacer save() en el siguiente codigo
        // Medio extranio pero lo hace, interesante
        AutorEntity autorSaved = this.autorRepository.save(autorToSave);
        return MaperPersistence.fromAutorEntityToAutor(autorSaved);
    }

    @Override
    public List<Autor> listarAutoresPorLibro(Libro libro) {
        LibroEntity libroEntity = MaperPersistence.fromLibroToLibroEntity(libro);
        libroEntity.setIdLibro(libro.getIdLibro());
        List<AutorEntity> listaAutoresEntity = this.autorRepository.findByIdLibro(libroEntity);
        return listaAutoresEntity.stream()
                .map(MaperPersistence::fromAutorEntityToAutor)
                .toList();
    }
}
