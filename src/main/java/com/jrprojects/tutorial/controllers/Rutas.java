package com.jrprojects.tutorial.controllers;

import com.jrprojects.tutorial.models.Libro;
import com.jrprojects.tutorial.models.Producto;
import com.jrprojects.tutorial.models.UserData;
import com.jrprojects.tutorial.myBeans.MiBean;
import com.jrprojects.tutorial.myBeans.MiComponente;
import com.jrprojects.tutorial.services.MisOperaciones;
import com.jrprojects.tutorial.services.OrderServiceable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Rutas {

    private final Logger logger = LoggerFactory.getLogger(Rutas.class);
    private final OrderServiceable orderService;
    private final MiBean miBean;
    private final MisOperaciones misOperaciones;
    @Autowired
    private MiComponente miComponente;      // <-- Forma deprecada de inyectar dependencias sin tener que meterlas explicitamente en el constructor

    public Rutas(OrderServiceable orderService, MiBean miBean, MisOperaciones misOperaciones) {
        this.orderService = orderService;
        this.miBean = miBean;
        this.misOperaciones = misOperaciones;
    }

    @GetMapping ("/")
    public Map<String, String> home() {
        return new HashMap<>(){{put("message", "Hello from Homepage");}};
    }

    @GetMapping ("/factorial")
    public Map<String, String> factorial(@RequestParam int numero){
        try {
            return new HashMap<>() {{put("factorial", "" + misOperaciones.factorial(numero));}};
        }
        catch (ArithmeticException e) {
            return new HashMap<>() {{put("error", "operación invalida");}};
        }
    }

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
        return new UserData("Josimar", 33, "Fortin, Ver, MX");
    }

    @PostMapping ("/order")
    public String crearOrden(@RequestBody List<Producto> products) {
        orderService.saveOrder(products);
        return "Orden creada...";
    }

    @GetMapping ("/mibean")
    public String llamarBean () {

        miBean.saludar();
        return "Completado...";
    }

    @GetMapping ("/micomponente")
    public String llamarComponente() {
        miComponente.saludarDesdeComponente();
        return "Llamado a miComponente completad...";
    }
}
