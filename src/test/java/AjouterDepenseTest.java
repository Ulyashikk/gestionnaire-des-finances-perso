/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import control.DepensesController;
import control.FinanceController;
import dialog.DialogDepensesWindow;
import java.util.Date;
import javax.swing.DefaultListModel;
import model.Depense;
import model.DepensesManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import presentation.DepensesWindow;
import presentation.FinanceWindow;

/**
 *
 * @author mac
 */
public class AjouterDepenseTest {
    
    private DialogDepensesWindow dialog;
    private FinanceController financeControl;
    private DepensesManager manager;
    private DepensesController controller;

    @BeforeEach
    public void setUp() {
        financeControl = new FinanceController(new FinanceWindow());
        dialog = new DialogDepensesWindow(new DepensesWindow(financeControl));
        manager = new DepensesManager();
        controller = new DepensesController(manager, dialog);
    }
    
    @Test
    public void testAjouterDepense() {
        Date date = new Date();
        double amount = 50.0;
        String description = "Groceries";
        Depense depense = new Depense(description, date, amount);
       
        controller.ajouterDepense(depense);

        assertEquals(50.0, manager.getTotalDepense(), 0.0);
        assertEquals(50.0, depense.getAmount());
        assertEquals("Groceries", depense.getDescription());
    }
    
    
    @Test
    public void testAjouterDepenseAvenir() {
        DefaultListModel pastDepenses = new DefaultListModel();
        DefaultListModel upcomingDepenses = new DefaultListModel();
        
        //Depense depense = new Depense("Vacation", new Date(System.currentTimeMillis() + 86400000), 500.0);
        
        dialog.addDepense(pastDepenses, upcomingDepenses);
        
        assertEquals(1, upcomingDepenses.size());
        assertEquals(0, pastDepenses.size());
    }

    @Test
    public void testAjouterDepensePasse() {
        DefaultListModel pastDepenses = new DefaultListModel();
        DefaultListModel upcomingDepenses = new DefaultListModel();
        
        //Depense depense = new Depense("Groceries", new Date(), 50.0);
        
        dialog.addDepense(pastDepenses, upcomingDepenses);
        
        assertNotNull(pastDepenses);
        assertEquals(0, upcomingDepenses.size());
        assertEquals(1, pastDepenses.size());
    }
}
