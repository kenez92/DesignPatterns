package com.kenez92;

import org.junit.Assert;
import org.junit.Test;

public class PizzaTestSuite {
    @Test
    public void testPizzaBuilder() {
        //Given
        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredient("Onion")
                .bottom("Thin")
                .sauce("Spicy")
                .ingredient("Ham")
                .ingredient("Mushrooms")
                .build();
        System.out.println(pizza);
        //When
        int howManyIngredients = pizza.getIngredients().size();
        //Then
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertEquals("Thin", pizza.getBottom());
        Assert.assertEquals("Spicy", pizza.getSauce());
    }
}