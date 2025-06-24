package com.literalura.domain.model;

public class Autor {
    private Long idAutor;
    private String nombre;
    private Long fechaNace;
    private Long fechaFallece;

    //Este campo si se va ha mostrar en la peristencia por ser de N:1
    //Que viene de un Libro tiene muchos Autores
    private Libro libro;


    public Autor() {

    }

    public Autor(
            Long idAutor,
            String nombre,
            Long fechaNace,
            Long fechaFallece,
            Libro libro
    ) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.fechaNace = fechaNace;
        this.fechaFallece = fechaFallece;
        this.libro = libro;
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

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
