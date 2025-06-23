package com.literalura.domain.model;

import java.util.List;

public class Libro {
    private Long idLibro;
    private String titulo;
    private String idioma;
    private double numDescargas;

    private List<String> autores;


    public Libro() {

    }

    public Libro(Long idLibro, String titulo, String idioma, double numDescargas, List<String> autores) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.idioma = idioma;
        this.numDescargas = numDescargas;
        this.autores = autores;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
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
}
