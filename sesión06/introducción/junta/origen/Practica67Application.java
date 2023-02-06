package com.example.practica67;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practica67Application {

    public static void main(String[] args) {
        SpringApplication.run(Practica67Application.class, args);
    }

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

    class CalculadoraTest {

        private Calculadora calculadora = new Calculadora();

        @Test
        @DisplayName("Prueba suma")
        void sumaTest() {
            int esperado = 5;

            assertEquals(esperado, calculadora.suma(3, 2));
        }

        @Test
        @DisplayName("Prueba resta")
        void restaTest() {
            int esperado = 1;

            assertEquals(esperado, calculadora.resta(3, 2));
        }

        @Test
        @DisplayName("Prueba multiplicación")
        void multiplicaTest() {
            int esperado = 6;

            assertEquals(esperado, calculadora.multiplica(3, 2));
        }
    }

    @ExtendWith(MockitoExtension.class)
    class CalculadoraTest {

        @Mock
        CalculadoraDao calculadoraDao;

        @InjectMocks
        Calculadora calculadora;


        @BeforeEach
        void setUp() {
            given(calculadoraDao.findValorConstante()).willReturn(3);
        }

        @Test
        @DisplayName("Prueba suma")
        void sumaTest() {
            int esperado = 8;
            assertEquals(esperado, calculadora.suma(3, 2));
        }

        @Test
        @DisplayName("Prueba resta")
        void restaTest() {
            int esperado = 4;
            assertEquals(esperado, calculadora.resta(3, 2));
        }

        @Test
        @DisplayName("Prueba multiplicación")
        void multiplicaTest() {
            int esperado = 9;
            assertEquals(esperado, calculadora.multiplica(3, 2));
        }
    }

}
