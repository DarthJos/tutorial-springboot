package com.jrprojects.tutorial;

import com.jrprojects.tutorial.models.Libro;
import com.jrprojects.tutorial.models.UserData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping ("/saludar")
    @ResponseStatus (value = HttpStatus.MOVED_PERMANENTLY, reason = "Fue movida a la versión 2 de la API")
    String miSegundaRutaConStatus() {
        return "Aprendiendo statuses http en Springboot";
    }

    @GetMapping ("/animales/{lugar}")
    public ResponseEntity<String> getAnimales(@PathVariable String lugar) {

        if (lugar.equals("granja")) {
            return ResponseEntity.status(HttpStatus.OK).body("Caballo, vaca, oveja, gallina");
        }
        else if (lugar.equals("selva")) {
            return ResponseEntity.status(HttpStatus.OK).body("Mono, gorila, puma");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lugar no valido.");
    }

    @GetMapping ("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero) {
        throw new NullPointerException("la clave del usuario es password123 y no debería leerse en postman");
    }

    /**
     * Retorna un Json después de crear una respuesta con header y body
     * @return un diccionario "user" que contiene otro diccionario que incluye age y name
     */
    @GetMapping ("/userData")
    public ResponseEntity<String> getUserData(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body("{\"name\":\"mary\"}");
    }

    /**
     * Por cada Map, se retorna un diccionario (Mapea un par clave-valor)
     * @return un diccionario "user" que contiene otro diccionario que incluye age y name
     */
    @GetMapping ("/userData/v2")
    public Map<String, Map<String, Object>> getUserDataV2() {
        return Map.of("user", Map.of("name", "mary", "age", 25));
    }

    /**
     * @return un Json tan solo mediante el uso de una clase modelo (UserData)
     */
    @GetMapping ("/userData/v3")
    public UserData getUserDataV3() {
        return new UserData("Josimar", 33);
    }

}
