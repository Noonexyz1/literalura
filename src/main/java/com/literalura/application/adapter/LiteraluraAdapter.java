package com.literalura.application.adapter;

import com.literalura.application.port.in.Literalura;
import com.literalura.application.port.out.persistence.AutorAbs;
import com.literalura.application.port.out.persistence.LibroAbs;
import com.literalura.application.port.out.petition.PeticionAbs;
import com.literalura.domain.model.Autor;
import com.literalura.domain.model.Libro;

import java.util.List;

//Implementamos mis Casos de Uso del paquete port.in
public class LiteraluraAdapter implements Literalura {

    //Aqui vamos injectando desde el paquete port.out para hacer uso todas
    //las funcionalidades necesarias para cumplir con el Caso de Uso
    private PeticionAbs peticionAbs;
    private AutorAbs autorAbs;
    private LibroAbs libroAbs;

    public LiteraluraAdapter(
            PeticionAbs peticionAbs,
            AutorAbs autorAbs,
            LibroAbs libroAbs
    ) {
        this.peticionAbs = peticionAbs;
        this.autorAbs = autorAbs;
        this.libroAbs = libroAbs;
    }

    @Override
    public Libro buscarLibro(String tituloLibro) {
        //Peticion a un sistema externo alguno
        Libro libro = peticionAbs.buscarLibro(tituloLibro);

        //Persistimos en algun lugar
        Libro libroRegistrado = libroAbs.resgistrarLibro(libro);

        //Devolvemos el libro persistido
        return libroRegistrado;
    }

    @Override
    public List<Libro> listarLibros() {
        return libroAbs.listarLibros();
    }

    @Override
    public List<Autor> listarAutores() {
        return autorAbs.listarAutores();
    }

    @Override
    public List<Autor> listarAutoresVivos(int anio) {
        return autorAbs.listarAutoresVivos(anio);
    }

    @Override
    public List<Libro> listarLibros(String codigoIdioma) {
        return libroAbs.listarLibros(codigoIdioma);
    }
}
