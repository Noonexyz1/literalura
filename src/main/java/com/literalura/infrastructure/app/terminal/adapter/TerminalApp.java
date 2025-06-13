package com.literalura.infrastructure.app.terminal.adapter;

import com.literalura.application.port.in.Literalura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TerminalApp {

    @Autowired
    private Literalura literalura;

    public void run() {
        //TODO, hacer la aplicaciones de consola
        System.out.println("Iniciamos la aplicacion TERMINAL");
    }

}
