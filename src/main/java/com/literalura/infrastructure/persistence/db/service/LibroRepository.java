package com.literalura.infrastructure.persistence.db.service;

import com.literalura.infrastructure.persistence.db.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
    //TODO, hacer los query metods de Autor
}
