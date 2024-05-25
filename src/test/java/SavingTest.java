/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import model.Saving;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mac
 */

public class SavingTest {

    private Saving saving;

    @BeforeEach
    public void setUp() {
        saving = new Saving("Emergency Fund", 1000.0);
    }

    @Test
    public void testGetName() {
        assertEquals("Emergency Fund", saving.getName());
    }

    @Test
    public void testGetAmount() {
        assertEquals(1000.0, saving.getAmount(), 0.0);
    }

    @Test
    public void testToString() {
        assertEquals("Emergency Fund : 1000.0", saving.toString());
    }

    @Test
    public void testToSaving() {
        String element = "Voyage Fund : 500.0";
        Saving newSaving = saving.toSaving(element);
        assertEquals("Voyage Fund", newSaving.getName());
        assertEquals(500.0, newSaving.getAmount(), 0.0);
    }
}

