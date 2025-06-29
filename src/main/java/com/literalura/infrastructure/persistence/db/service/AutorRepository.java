package com.literalura.infrastructure.persistence.db.service;

import com.literalura.infrastructure.persistence.db.entity.AutorEntity;
import com.literalura.infrastructure.persistence.db.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
    List<AutorEntity> findByIdLibro(LibroEntity libroEntity);

    //Esto tiene que ser JPA
    @Query("""
            SELECT a
            FROM AutorEntity a
            WHERE a.fechaNace <= :anio
            AND :anio <= a.fechaFallece
            """)
    List<AutorEntity> listarAutoresVivos(@Param("anio") int anio);
}
