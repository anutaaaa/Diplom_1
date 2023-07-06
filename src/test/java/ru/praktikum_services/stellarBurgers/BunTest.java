package ru.praktikum_services.stellarBurgers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private Bun bun;

    @Before
    public void initBun() {
        bun = new Bun("Краторная булка N-200i", 1255);
    }

    @Test
    public void getBunName() {
        Assert.assertEquals("Краторная булка N-200i", bun.getName());
    }

    @Test
    public void getBunPrice() {
        Assert.assertEquals(1255, bun.getPrice(), 0);
    }
}