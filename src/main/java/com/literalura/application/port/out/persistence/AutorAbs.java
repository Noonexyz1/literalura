package com.literalura.application.port.out.persistence;

import com.literalura.domain.model.Autor;
import com.literalura.domain.model.Libro;

import java.util.List;

//Aqui estan todas las operaciones crud de MODELO Autor o las necesarias :)
public interface AutorAbs {
    List<Autor> listarAutores();
    List<Autor> listarAutoresVivos(int anio);
    Autor guardarAutor(Autor autor);
    List<Autor> listarAutoresPorLibro(Libro libro);
}
