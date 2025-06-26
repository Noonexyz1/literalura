package com.literalura.infrastructure.petition.rest.adapter;

import com.literalura.application.port.out.petition.PeticionAbs;
import com.literalura.domain.model.Autor;
import com.literalura.domain.model.Libro;
import com.literalura.infrastructure.petition.rest.data.LibroData;
import com.literalura.infrastructure.petition.rest.data.ResultData;
import com.literalura.infrastructure.petition.rest.exception.LibroNoEncontradoException;
import com.literalura.infrastructure.petition.rest.service.ConvierteDatos;
import com.literalura.infrastructure.petition.rest.utils.MaperPeticion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Component
public class PeticionAdapter implements PeticionAbs {

    @Autowired
    private ConvierteDatos convierteDatos;

    //Aqui necesito definir las URLS y demas atributos necesarios para hacer la peticion
    private String URL_BASE = "https://gutendex.com/books/";


    @Override
    public Libro buscarLibro(String tituloLibro) {
        //Hacemos la peticion al sistema externo
        String resultado = this.obtenerDatos(URL_BASE);

        //Al parece necesariamente voy a tener que mapear Modelos Anidados, ya no, porque tengo un ResultData que me trae
        //el campo que realmente necesito, Entra a ResultaData para nortarlo
        //Convertir el resultado Sptring/Json a un modelo de datos
        ResultData libroData = convierteDatos.convierteDatos(resultado, ResultData.class);

        //Buscamos en la lista el libro que se nos pasa por parametro
        Optional<LibroData> libroEncontrado = libroData.listaLibros().stream()
                .filter(x -> {
                    String valor = x.titulo().toLowerCase();
                    String valor2 = tituloLibro.toLowerCase();
                    return valor.contains(valor2);
                })
                .findFirst();

        //Comprobamos si existe este valor
        if (libroEncontrado.isEmpty()) {
            throw new LibroNoEncontradoException("Libro no encontrado");
        }

        Libro libro = MaperPeticion.fromLibroDataToLibro(libroEncontrado.get());

        //Retornamos el valor
        return libro;
    }

    @Override
    public List<Autor> buscarAutores(String tituloLibro) {
        //Hacemos la peticion al sistema externo
        String resultado = this.obtenerDatos(URL_BASE);

        //Al parece necesariamente voy a tener que mapear Modelos Anidados, ya no, porque tengo un ResultData que me trae
        //el campo que realmente necesito, Entra a ResultaData para nortarlo
        //Convertir el resultado Sptring/Json a un modelo de datos
        ResultData libroData = convierteDatos.convierteDatos(resultado, ResultData.class);

        //Buscamos en la lista el libro que se nos pasa por parametro
        Optional<LibroData> libroEncontrado = libroData.listaLibros().stream()
                .filter(x -> {
                    String valor = x.titulo().toLowerCase();
                    String valor2 = tituloLibro.toLowerCase();
                    return valor.contains(valor2);
                })
                .findFirst();

        //Obtenemos la lista de los autores del libro
        return libroEncontrado.get().autores().stream()
                .map(MaperPeticion::fromAutorDataToAutor)
                .toList();
    }

    private String obtenerDatos(String url){
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }

}
