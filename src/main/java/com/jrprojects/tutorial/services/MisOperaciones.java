package com.jrprojects.tutorial.services;

import org.springframework.stereotype.Service;

@Service
public class MisOperaciones implements Operaciones{
    @Override
    public int factorial(int num) {

        if (num < 0) throw new ArithmeticException();

        if (num >23) throw new IllegalArgumentException("Overflow from integer, use max 23");

        if (num == 1 || num == 0) return 1;
        return num * factorial(num -1 );
    }
}
