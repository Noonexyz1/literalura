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


    /*
    * Yo como Caso de Uso, no deberia usar mapeadores, asi se ve mas limpio el codigo
    * */


    @Override
    public Libro buscarLibro(String tituloLibro) {
        //Peticion a un sistema externo alguno API
        Libro libro = peticionAbs.buscarLibro(tituloLibro);

        //Persistimos en algun lugar
        Libro libroRegistrado = libroAbs.resgistrarLibro(libro);

        //Buscamos y traemos la lista de autores del libro encontrado a nuestra API
        List<Autor> listaDeAutoresLibro = this.peticionAbs.buscarAutores(tituloLibro);

        listaDeAutoresLibro.forEach(x -> {

            Libro libroLink = new Libro();
            libroLink.setIdLibro(libroRegistrado.getIdLibro());
            x.setLibro(libroLink);
            autorAbs.guardarAutor(x);

        });

        //Devolvemos el libro persistido
        return libroRegistrado;
    }

    //Este metodo es para traer datos persistidos
    @Override
    public List<Libro> listarLibros() {
        return libroAbs.listarLibros();
    }

    //Este metodo es para traer datos persistidos
    @Override
    public List<Autor> listarAutores() {
        return autorAbs.listarAutores();
    }

    //Este metodo es para traer datos persistidos
    @Override
    public List<Autor> listarAutoresVivos(int anio) {
        return autorAbs.listarAutoresVivos(anio);
    }

    //Este metodo es para traer datos persistidos
    @Override
    public List<Libro> listarLibros(String codigoIdioma) {
        return libroAbs.listarLibros(codigoIdioma);
    }

    @Override
    public List<Autor> listarAutoresPorLibro(Libro libro) {
        return this.autorAbs.listarAutoresPorLibro(libro);
    }
}
