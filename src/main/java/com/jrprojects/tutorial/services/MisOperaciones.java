package com.jrprojects.tutorial.services;

import org.springframework.stereotype.Service;

@Service
public class MisOperaciones implements Operaciones{
    @Override
    public int factorial(int num) {
        if (num == 1) return 1;
        return num * factorial(num -1 );
    }
}
