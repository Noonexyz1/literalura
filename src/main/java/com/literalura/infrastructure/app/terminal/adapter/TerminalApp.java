package com.literalura.infrastructure.app.terminal.adapter;

import com.literalura.application.port.in.Literalura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TerminalApp {

    @Autowired
    private Literalura literalura;

    //Mis variables globales
    private final List<String> listaDeOpciones = new ArrayList<>();



    public void iniciarApp() {
        //TODO, hacer la aplicaciones de consola


        this.iniciarListaDeOpciones();


        System.out.println("Mostramos la lista de opciones---------");
        listaDeOpciones.forEach(System.out::println);
    }




    public void iniciarListaDeOpciones() {
        this.listaDeOpciones.add("1.- Buscar libro por titulo");
        this.listaDeOpciones.add("2.- Listar libros registrados");
        this.listaDeOpciones.add("3.- Listar autores registrados");
        this.listaDeOpciones.add("4.- Listar autores vivos por anio");
        this.listaDeOpciones.add("5.- Listar libros por idioma");
        this.listaDeOpciones.add("0.- Salir");
    }
}
