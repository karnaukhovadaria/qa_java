package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineTest {

    @Test
    void eatMeatTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = new Feline().eatMeat();
        assertEquals(expected, actual);
    }
    @Test
    void getFamilyTest() {
        assertEquals(1, new Feline().getKittens());
    }

    @Test
    void getKittensParameterTest() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3));
        assertEquals(5, feline.getKittens(5));
        assertEquals(0, feline.getKittens(0));
    }
}
