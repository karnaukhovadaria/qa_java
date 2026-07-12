package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CatTest {
    @Mock
    private Feline felineMock;
    private Cat cat;
    @BeforeEach
    void setUp() {
        cat = new Cat(felineMock);
    }
    @Test
    void testGetFoodMockedFeline() throws Exception {
        List<String> mockFood = Arrays.asList("Мясо", "Рыба", "Птица");
        when(felineMock.eatMeat()).thenReturn(mockFood);
        List<String> result = cat.getFood();

        assertEquals(mockFood, result);
        assertEquals(3, result.size());
        assertTrue(result.contains("Мясо"));
        verify(felineMock, times(1)).eatMeat();
    }
    @Test
    void testGetFoodException() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Feline error"));

        assertThrows(Exception.class, () -> cat.getFood());
        verify(felineMock, times(1)).eatMeat();
    }
    @Test
    void testGetSound() throws Exception {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
        verify(felineMock, never()).eatMeat();
    }
}






