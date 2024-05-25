/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author mac
 */

import dialog.DialogDepensesWindow;
import model.Budget;
import presentation.DepensesWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Depense;
import model.DepensesManager;

public class DepensesController {

    private DepensesManager manager;
    private DialogDepensesWindow dialog;

    public DepensesController(DepensesManager manager, DialogDepensesWindow dialog) {
        this.manager = manager;
        this.dialog = dialog;
    }

    public void ajouterDepense(Depense depense){
        manager.newDepense(depense.getDescription(), depense.getDate(), depense.getAmount());
    }
    
    public void deleteDepense(int numDepense){
        manager.deleteDepense(numDepense);
    }
    
    public void modifierDepense(Depense depense, int numDepense){
        manager.modifierDepense(depense.getDescription(), depense.getDate(), depense.getAmount(), numDepense);
    }
    
    public double getTotalDepenses(){
        return manager.getTotalDepense();
    }
    
    public Depense getDepense(int numDepense){
        return manager.getDepense(numDepense);
    }
}
