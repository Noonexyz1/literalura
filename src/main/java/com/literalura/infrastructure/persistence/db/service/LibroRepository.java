package com.literalura.infrastructure.persistence.db.service;

import com.literalura.infrastructure.persistence.db.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
    List<LibroEntity> findByIdioma(String codigoIdioma);
    LibroEntity findByTitulo(String titulo);
}
