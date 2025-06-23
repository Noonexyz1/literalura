package com.literalura.infrastructure.persistence.db.adapter;

import com.literalura.application.port.out.persistence.AutorAbs;
import com.literalura.domain.model.Autor;
import com.literalura.infrastructure.persistence.db.entity.AutorEntity;
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
                .map(MaperPersistence::fromAutorEntitityToAutor)
                .toList();
    }

    @Override
    public List<Autor> listarAutoresVivos(int anio) {
        //TODO, buscar por columa anio
        return autorRepository.findAll().stream()
                .map(MaperPersistence::fromAutorEntitityToAutor)
                .toList();
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        AutorEntity autorToSave = MaperPersistence.fromAutorToAutorEntitity(autor);
        // autorToSave se va ha mutar por jpa despues de hacer save() en siguiente codigo
        //Medio extranio pero lo hace, interesante
        AutorEntity autorSaved = this.autorRepository.save(autorToSave);
        return MaperPersistence.fromAutorEntitityToAutor(autorSaved);
    }
}
