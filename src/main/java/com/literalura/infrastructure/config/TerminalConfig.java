package com.literalura.infrastructure.config;

import com.literalura.infrastructure.app.terminal.adapter.TerminalApp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TerminalConfig {

    @Bean
    public CommandLineRunner terminalCommandLineRunner(TerminalApp terminalApp) {
        return args -> {

            terminalApp.run();

            // Si necesitas acceder a los argumentos de línea de comandos
            /*if (args.length > 0) {
                //terminalApp.procesarArgumentos(args);
            }*/

        };
    }
}
