package com.jrprojects.tutorial.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OperacionesTest {

    private Operaciones operaciones;

    @BeforeEach
    public void setup() {
        operaciones = new MisOperaciones();
    }

    /**
     * Success test Cases
     */
    @Test
    public void factorial_Test() {
        Assertions.assertEquals(operaciones.factorial(0), 1);
        Assertions.assertEquals(operaciones.factorial(1), 1);
        Assertions.assertEquals(operaciones.factorial(4), 24);
        Assertions.assertEquals(operaciones.factorial(5), 120);
    }

    /**
     * Fail Test Cases
     */
    @Test
    public void factorial_FailTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> operaciones.factorial(-1));

        Assertions.assertThrows(ArithmeticException.class, () -> operaciones.factorial(-10));

        Assertions.assertThrows(IllegalArgumentException.class, () -> operaciones.factorial(24));
    }
}
