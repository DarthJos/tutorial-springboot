package com.jrprojects.tutorial.myBeans;

import com.jrprojects.tutorial.models.Producto;
import com.jrprojects.tutorial.services.OrderService;
import com.jrprojects.tutorial.services.OrderServiceable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MisPrimerosBeans {

    @Bean
    public MiBean crearMiBean() {
        return new MiBean();
    }

    @Bean
    public OrderServiceable instanciarOrderService() {
        boolean esProduccion = false;

        if (esProduccion) {
            return new OrderService();
        }
        else {
            return productos -> {
                productos.forEach(producto -> System.out.println("Dummy:: "+ producto.getNombre()+ ": $"+ producto.getPrecio()));
                System.out.println("Guardando productos en la BD Dummy (local)...");
            };
        }
    }
}
