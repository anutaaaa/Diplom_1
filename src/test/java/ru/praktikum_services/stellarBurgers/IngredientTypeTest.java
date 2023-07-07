package ru.praktikum_services.stellarBurgers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final String nameOfType;

    public IngredientTypeTest(IngredientType type, String nameOfType) {
        this.type = type;
        this.nameOfType = nameOfType;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void getIngredientTypeTest() {
        Assert.assertEquals(type, IngredientType.valueOf(nameOfType));
    }

}
