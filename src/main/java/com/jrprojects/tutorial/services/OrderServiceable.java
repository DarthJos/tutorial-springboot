package com.jrprojects.tutorial.services;

import com.jrprojects.tutorial.models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderServiceable {

    void saveOrder(List<Producto> productos);
}
