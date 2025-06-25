package com.literalura.application.port.out.petition;

import com.literalura.domain.model.Autor;
import com.literalura.domain.model.Libro;

import java.util.List;

//Aqui estan todas las operaciones de Peticiones Externas a otros sistemas
//necesarias para cumplir con mi Uses Cases
public interface PeticionAbs {
    Libro buscarLibro(String tituloLibro);
    List<Autor> buscarAutores(String tituloLibro);
}
