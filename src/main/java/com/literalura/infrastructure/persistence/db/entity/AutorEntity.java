package com.literalura.infrastructure.persistence.db.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "autor")
public class AutorEntity {

    @Id
    private Long idAutor;
    private String nombre;
    private Long fechaNace;
    private Long fechaFallece;

    @ManyToOne
    @JoinColumn(name = "fk_libro")
    private LibroEntity idLibro;


    public AutorEntity() {

    }

    public AutorEntity(
            Long idAutor,
            String nombre,
            Long fechaNace,
            Long fechaFallece,
            LibroEntity idLibro
    ) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.fechaNace = fechaNace;
        this.fechaFallece = fechaFallece;
        this.idLibro = idLibro;
    }


    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getFechaNace() {
        return fechaNace;
    }

    public void setFechaNace(Long fechaNace) {
        this.fechaNace = fechaNace;
    }

    public Long getFechaFallece() {
        return fechaFallece;
    }

    public void setFechaFallece(Long fechaFallece) {
        this.fechaFallece = fechaFallece;
    }

    public LibroEntity getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(LibroEntity idLibro) {
        this.idLibro = idLibro;
    }
}
