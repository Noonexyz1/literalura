package com.literalura.infrastructure.app.terminal.adapter;

import com.literalura.application.port.in.Literalura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class TerminalApp {

    @Autowired
    private Literalura literalura;

    //Mis variables globales
    private final List<String> listaDeOpciones = new ArrayList<>();


    public void iniciarApp() {
        //TODO, hacer la aplicaciones de consola

        this.iniciarListaDeOpciones();

        boolean opcionSalir = true;
        do {
            System.out.println("-------------- Lista de opciones ----------------");
            listaDeOpciones.forEach(System.out::println);

            System.out.println("-------------- Ingrese una opcion ----------------");
            int opcion = new Scanner(System.in).nextInt();

            if (opcion == 0) {
                opcionSalir = false;
            }

        } while (opcionSalir);

        System.out.println("--------------- Fin del programa -----------------\n");

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
