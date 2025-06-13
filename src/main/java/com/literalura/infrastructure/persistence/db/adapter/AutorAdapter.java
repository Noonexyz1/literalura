package com.literalura.infrastructure.persistence.db.adapter;

import com.literalura.application.port.out.persistence.AutorAbs;
import com.literalura.domain.model.Autor;
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
}
