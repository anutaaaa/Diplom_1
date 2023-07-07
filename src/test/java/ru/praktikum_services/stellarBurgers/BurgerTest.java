package ru.praktikum_services.stellarBurgers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(Burger.bun, bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "Флюоресцентная булка R2-D3", 988));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88));
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Флюоресцентная булка R2-D3", burger.ingredients.get(1).name);;
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(1500F);
        burger.setBuns(bun);
        Mockito.when(ingredient.getPrice()).thenReturn(500F);
        burger.addIngredient(ingredient);
        float price1 = burger.getPrice();
        float price2 = (1500*2 + 500);
        Assert.assertEquals(price2, price1, 0);
    }

    @After
    public void cleanIngredientsList() {
        burger.ingredients.clear();
    }
}