package ru.praktikum_services.stellarBurgers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус традиционный галактический", 15},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337}
        };
    }

    @Before
    public void initIngredient() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceTest() {
        float actualPrice = ingredient.getPrice();
        float expectedPrice = ingredient.price;
        Assert.assertEquals(expectedPrice, actualPrice, 0.0f);
    }

    @Test
    public void getNameTest() {
        String actualName = ingredient.getName();
        String expectedName = ingredient.name;
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getTypeTest() {
        IngredientType actualType = ingredient.getType();
        IngredientType expectedName = ingredient.type;
        Assert.assertEquals(expectedName, actualType);
    }

}