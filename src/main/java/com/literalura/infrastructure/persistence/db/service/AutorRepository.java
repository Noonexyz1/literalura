package com.literalura.infrastructure.persistence.db.service;

import com.literalura.infrastructure.persistence.db.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
    //TODO, hacer los query metods de Autor
}
