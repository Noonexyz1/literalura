package com.literalura.domain.model;

public class Autor {
    private Long idAutor;
    private String nombre;
    private String fechaNace;
    private String fechaFallece;

    private Long idLibro;


    public Autor() {

    }

    public Autor(Long idAutor, String nombre, String fechaNace, String fechaFallece, Long idLibro) {
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

    public String getFechaNace() {
        return fechaNace;
    }

    public void setFechaNace(String fechaNace) {
        this.fechaNace = fechaNace;
    }

    public String getFechaFallece() {
        return fechaFallece;
    }

    public void setFechaFallece(String fechaFallece) {
        this.fechaFallece = fechaFallece;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }
}
