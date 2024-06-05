package com.jrprojects.tutorial;

import com.jrprojects.tutorial.models.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class Rutas {

    private final Logger logger = LoggerFactory.getLogger(Rutas.class);

    @GetMapping ("/hola")
    String miPrimeraRuta() {
        return "Hola mundo desde Spring Controller";
    }

    @GetMapping ("/libro/{id}/editorial/{editorial}")
    String leerLibro(@PathVariable int id, @PathVariable String editorial) {
        return "Leyendo el libro id: " + id + ", editorial: " + editorial;
    }

    @GetMapping ("/libro2/{id}")
    String leerLibroParams(@PathVariable int id, @RequestParam  String param1, @RequestParam String editorial) {
        return "Leyendo el libro id: " + id + ", param1: " + param1 + ", editorial: "+ editorial;
    }

    @PostMapping ("/libro")
    String guardarLibro(@RequestBody Libro libro) {
        logger.debug("libro {} editorial {} ", libro.nombre, libro.editorial);

        if (libro.nombre == null) throw new IllegalArgumentException("Microservicio fallado");

        return "Libro guardado...";
    }

    @GetMapping ("/Saludar")
    @ResponseStatus (value = HttpStatus.MOVED_PERMANENTLY, reason = "Fue movida a la versión 2 de la API")
    String miSegundaRutaConStatus() {
        return "Aprendiendo statuses http en Springboot";
    }
}
