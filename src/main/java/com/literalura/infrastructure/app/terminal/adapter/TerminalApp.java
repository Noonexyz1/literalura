package com.literalura.infrastructure.app.terminal.adapter;

import com.literalura.application.port.in.Literalura;
import com.literalura.domain.model.Autor;
import com.literalura.domain.model.Libro;
import com.literalura.infrastructure.app.terminal.model.OpcionModel;
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
    private final List<OpcionModel> listaDeOpciones = new ArrayList<>();
    private boolean opcionSalir = true;


    public void iniciarApp() {

        this.iniciarListaDeOpciones();

        do {
            System.out.println("-------------- Lista de opciones ----------------");
            this.listaDeOpciones.forEach(x -> System.out.println(x.getOpcionLiteral()));

            System.out.println("-------------- Ingrese una opcion ----------------");
            int opcion = new Scanner(System.in).nextInt();

            //Buscamos y ejecutamos en base la opcion del usuario la operacion de ejecutar
            this.listaDeOpciones.stream().filter(x -> x.getOpcionNumerica() == opcion)
                    .forEach(x -> x.getEjecutarOpcion().run());

        } while (this.opcionSalir);

        System.out.println("--------------- Fin del programa -----------------\n");

    }

    public void iniciarListaDeOpciones() {
        this.listaDeOpciones.add(new OpcionModel(1, "1.- Buscar libro por titulo", this::buscarLibroPorTitulo));
        this.listaDeOpciones.add(new OpcionModel(2, "2.- Listar libros registrados", this::listarLibros));
        this.listaDeOpciones.add(new OpcionModel(3, "3.- Listar autores registrados", this::listarAutores));
        this.listaDeOpciones.add(new OpcionModel(4, "4.- Listar autores vivos por anio", this:: listarAutoresVivos));
        this.listaDeOpciones.add(new OpcionModel(5, "5.- Listar libros por idioma", this::listarLibrosPorIdioma));
        this.listaDeOpciones.add(new OpcionModel(0, "0.- Salir", this::terminarApp));
    }

    //Yo estoy pasando estos comportamientos a mi lista de OpcionModel, asi es mas sencillo empaquetar logica :)
    public void buscarLibroPorTitulo() {
        //Esta es la forma correcta para utilizar SERVICIOS con opciones que mostrar
        System.out.println("Ingrese el nombre del Libro:");
        String nombreLibro = new Scanner(System.in).nextLine();
        Libro libro = this.literalura.buscarLibro(nombreLibro);
        this.mostrarLibroFormat(libro);
    }

    public void listarLibros() {
        this.literalura.listarLibros().forEach(this::mostrarLibroFormat);
    }

    public void listarAutores() {
        this.literalura.listarAutores().forEach(this::mostrarAutorFormat);
    }

    public void listarAutoresVivos() {
        int anio = new Scanner(System.in).nextInt();
        this.literalura.listarAutoresVivos(anio).forEach(this::mostrarAutorFormat);
    }

    public void listarLibrosPorIdioma() {
        String codigoIdioma = new Scanner(System.in).next();
        this.literalura.listarLibros(codigoIdioma).forEach(this::mostrarLibroFormat);
    }

    public void terminarApp() {
        //Este valor los necesito en GLOBAL para que pueda terminar la ejecucion desde otro metodo fuera
        this.opcionSalir = false;
    }


    public void mostrarLibroFormat(Libro libro) {
        String datos = String.format("""
                    Titulo: %s
                    Autor: %s
                    Idioma: %s
                    Numero de descargas: %f
                """,
                libro.getTitulo(), "Mostrar Autor", libro.getIdioma(), libro.getNumDescargas());

        System.out.println("---------- LIBRO ----------");
        System.out.println(datos);
        System.out.println("---------------------------");
    }

    public void mostrarAutorFormat(Autor autor) {
        String datos = String.format("""
                    Autor: %s
                    Fecha de nacimiento: %s
                    Fecha de fallecimiento: %s
                    Libros: [%s]
                """,
                autor.getNombre(), autor.getFechaNace(), autor.getFechaFallece(), autor.getIdLibro());

        System.out.println("---------- AUTOR ----------");
        System.out.println(datos);
        System.out.println("---------------------------");
    }
}
