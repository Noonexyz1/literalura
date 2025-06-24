package com.literalura.application.port.in;

import com.literalura.domain.model.Autor;
import com.literalura.domain.model.Libro;

import java.util.List;

//Dividir cuales son IN y Cuales son OUT no????
public interface Literalura {
    Libro buscarLibro(String tituloLibro);
    List<Libro> listarLibros();
    List<Autor> listarAutores();
    List<Autor> listarAutoresVivos(int anio);
    List<Libro> listarLibros(String codigoIdioma);
    List<Autor> listarAutoresPorLibro(Libro libro);
}
