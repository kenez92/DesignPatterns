package com.kenez92.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    public void testAdd() {
        //Given
        //When
        double result = calculator.add(10, 15);
        //Then
        assertEquals(25, result, 0);
    }

    @Test
    public void testSub() {
        //Given
        //When
        double result = calculator.subtract(10, 15);
        //Then
        assertEquals(-5, result, 0);
    }

    @Test
    public void testMul() {
        //Given
        //When
        double result = calculator.multiply(10, 15);
        //Then
        assertEquals(150, result, 0);
    }

    @Test
    public void testDiv() {
        //Given
        //When
        double result = calculator.divide(15, 5);
        //Then
        assertEquals(3, result, 0);
    }

    @Test
    public void testFactorial() {
        //Given
        //When
        BigDecimal result = calculator.factorial(new BigDecimal("10"));
        //Then
        assertEquals(new BigDecimal(3628800), result);
    }
}