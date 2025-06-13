package com.literalura.infrastructure.persistence.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "libro")
public class LibroEntity {

    @Id
    private Long idLibro;
    private String titulo;
    private String idioma;
    private double numDescargas;

    @OneToMany(mappedBy = "idLibro")
    private List<AutorEntity> autores;


    public LibroEntity() {
    }

    public LibroEntity(
            Long idLibro,
            String titulo,
            String idioma,
            double numDescargas,
            List<AutorEntity> autores
    ) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.idioma = idioma;
        this.numDescargas = numDescargas;
        this.autores = autores;
    }


    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public double getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(double numDescargas) {
        this.numDescargas = numDescargas;
    }

    public List<AutorEntity> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorEntity> autores) {
        this.autores = autores;
    }
}
