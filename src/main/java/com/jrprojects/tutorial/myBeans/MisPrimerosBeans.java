package com.jrprojects.tutorial.myBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MisPrimerosBeans {

    @Bean
    public MiBean crearMiBean() {
        return new MiBean();
    }
}
