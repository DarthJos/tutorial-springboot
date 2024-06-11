package com.jrprojects.tutorial.services;

import com.jrprojects.tutorial.models.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class OrderService implements OrderServiceable {

    @Value("${urls.database}")
    private String databaseURL;
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public void saveOrder (List<Producto> productos) {

        productos.forEach(producto -> logger.debug(producto.getNombre()+ ": $"+ producto.getPrecio()));
        System.out.println("Accediendo a " + databaseURL + "...  \nGuardando productos en la BD...");
    }
}
