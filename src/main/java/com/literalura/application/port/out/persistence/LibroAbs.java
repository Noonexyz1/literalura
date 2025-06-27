package com.literalura.application.port.out.persistence;

import com.literalura.domain.model.Libro;

import java.util.List;

//Aqui estan todas las operaciones crud del MODELO Libro o las necesarias :)
public interface LibroAbs {
    Libro resgistrarLibro(Libro libro);
    List<Libro> listarLibros();
    List<Libro> listarLibros(String codigoIdioma);
    Libro buscarLibroPorTitulo(String titulo);
}
