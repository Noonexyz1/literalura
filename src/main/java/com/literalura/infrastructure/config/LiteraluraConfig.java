package com.literalura.infrastructure.config;

import com.literalura.application.adapter.LiteraluraAdapter;
import com.literalura.application.port.in.Literalura;
import com.literalura.application.port.out.persistence.AutorAbs;
import com.literalura.application.port.out.persistence.LibroAbs;
import com.literalura.application.port.out.petition.PeticionAbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LiteraluraConfig {

    @Autowired
    private AutorAbs autorAbs;
    @Autowired
    private LibroAbs libroAbs;
    @Autowired
    private PeticionAbs peticionAbs;


    @Bean //Tambien es posible injectar dependencias por los paramestros de este metodo
    public Literalura literaluraBean() {
        return new LiteraluraAdapter(peticionAbs, autorAbs, libroAbs);
    }

}
