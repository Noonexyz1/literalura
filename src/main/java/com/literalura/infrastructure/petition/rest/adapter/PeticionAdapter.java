package com.literalura.infrastructure.petition.rest.adapter;

import com.literalura.application.port.out.petition.PeticionAbs;
import com.literalura.domain.model.Libro;
import com.literalura.infrastructure.petition.rest.data.LibroData;
import com.literalura.infrastructure.petition.rest.service.ConvierteDatos;
import com.literalura.infrastructure.petition.rest.service.PeticionService;
import com.literalura.infrastructure.petition.rest.utils.MaperPeticion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeticionAdapter implements PeticionAbs {

    @Autowired
    private PeticionService peticionService;
    @Autowired
    private ConvierteDatos convierteDatos;

    @Override
    public Libro buscarLibro(String tituloLibro) {
        //Hacemos la peticion al sistema externo
        String resultado = peticionService.obtenerDatos(tituloLibro);

        //Convertir el resultado Sptring/Json a un modelo de datos
        LibroData libroData = convierteDatos.convierteDatos(resultado, LibroData.class);

        //TODO, al parece necesariamente voy a tener que mapear Modelos Anidados
        //Mapeamos
        Libro libro = MaperPeticion.fromLibroDataToLibro(libroData);

        //Retornamos el valor
        return libro;
    }
}
