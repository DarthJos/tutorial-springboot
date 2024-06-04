package com.jrprojects.tutorial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rutas {

    @GetMapping ("/hola")
    String miPrimeraRuta() {
        return "Hola mundo desde Spring Controller";
    }

    @GetMapping ("/libro/{id}/editorial/{editorial}")
    String leerLibro(@PathVariable int id, @PathVariable String editorial) {
        return "Leyendo el libro id: " + id + ", editorial: " + editorial;
    }
}
