package com.literalura.application.port.out.petition;

import com.literalura.domain.model.Libro;

//Aqui estan todas las operaciones de Peticiones Externas a otros sistemas
//necesarias para cumplir con mi Uses Cases
public interface PeticionAbs {
    Libro buscarLibro(String tituloLibro);
}
