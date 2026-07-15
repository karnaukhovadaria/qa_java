package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline feline;

    @Test
    void getKittens_ShouldCallFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(3);

        int result = lion.getKittens();

        assertEquals(3, result);
        verify(feline, times(1)).getKittens();
    }

    @Test
    void doesHaveMane_Male_ShouldReturnTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void doesHaveMane_Female_ShouldReturnFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void getFood_ShouldCallFelineGetFoodWithPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        verify(feline, times(1)).getFood("Хищник");
    }
}