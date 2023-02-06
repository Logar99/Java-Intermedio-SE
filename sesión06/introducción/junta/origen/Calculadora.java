package com.example.practica67;

public class Calculadora{

    public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }

    public int multiplica(int a, int b) {
        return a * b;
    }
}


public class Calculadora {

    private CalculadoraDao calculadoraDao;

    public int suma(int a, int b) {
        return a + b + calculadoraDao.findValorConstante();
    }

    public int resta(int a, int b) {
        return a - b + calculadoraDao.findValorConstante();
    }

    public int multiplica(int a, int b) {
        return a * b + calculadoraDao.findValorConstante();
    }

    class CalculadoraSumaTest {

        static Calculadora calculadora;

        @BeforeAll
        static void setup() {
            calculadora = new Calculadora();

        }

        @Test
        @DisplayName("Prueba suma")
        void sumaTest() {
            int esperado = 5;
            assertEquals(esperado, calculadora.suma(3, 2));
        }

        class CalculadoraRestaTest {

            static Calculadora calculadora;

            @BeforeAll
            static void setup() {
                calculadora = new Calculadora();

            }

            @Test
            @DisplayName("Prueba resta")
            void restaTest() {
                int esperado = 1;
                assertEquals(esperado, calculadora.resta(3, 2));
            }
        }

        class CalculadoraMultiplicaTest {

            static Calculadora calculadora;

            @BeforeAll
            static void setup() {
                calculadora = new Calculadora();
            }

            @Test
            @DisplayName("Prueba multiplicación")
            void multiplicaTest() {
                int esperado = 6;
                assertEquals(esperado, calculadora.multiplica(3, 2));
            }
        }

        @Suite
        @SelectClasses({CalculadoraSumaTest.class, CalculadoraRestaTest.class, CalculadoraMultiplicaTest.class, CalculadoraDivideTest.class})
        class CalculadoraTest {

        }

    }



