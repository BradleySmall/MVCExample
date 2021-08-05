package com.lowes;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MVCExample_Test {
    @Test
    public void shouldCreateModel() {
        assertNotNull(new Model());
    }
    @Test
    public void shouldGetSomeData() {

        Model m = new Model();

        System.out.println(m.getCurrentData());
        m.nextData();
        System.out.println(m.getCurrentData());

    }
    @Test
    public void shouldCreateView() {
        assertNotNull(new View());
    }
    @Test
    public void shouldCreateController() {
        assertNotNull(new Controller(new Model(), new View()));
    }
}
