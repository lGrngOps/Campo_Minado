package br.com.cod3r.cm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Teste {

    @Test
    void testar(){
        int a = 1 + 1;
        assertEquals(2,a);
    }

    @Test
    void testar2(){
        int b = 2 + 10 - 9;
        assertEquals(3,b);
    }
}
