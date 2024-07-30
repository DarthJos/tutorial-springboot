package com.jrprojects.tutorial.services;

import com.jrprojects.tutorial.models.Producto;
import com.jrprojects.tutorial.utils.UtilsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class OrderService implements OrderServiceable {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Value("${urls.database}")
    private String databaseURL;

    public void saveOrder (List<Producto> productos) {

        productos.forEach(producto -> logger.debug(producto.getNombre()+ ": $"+ producto.getPrecio()));
        UtilsProvider.logDataBaseProperties();
        System.out.println("Guardando productos en la BD..." + databaseURL);
    }
}
