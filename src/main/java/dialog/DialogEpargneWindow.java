/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialog;

import control.*;
import javax.swing.DefaultListModel;
import model.*;
import presentation.*;

/**
 *
 * @author mac
 */
public class DialogEpargneWindow {
    
    private EpargneWindow view;
    private EpargneController control;
    private EpargneManager manager;
    
    public DialogEpargneWindow(EpargneWindow epargneWindow){
        this.view = epargneWindow;
        
        manager = new EpargneManager();
        control = new EpargneController(manager, this);
    }
    
    public void addSaving(DefaultListModel savings){
        Saving saving = view.getNewSavingInput();
        control.ajouterSaving(saving);
        savings.addElement(saving.toString());
        updateSavingsTotal();
    }
        
    public void modifierSaving(int index, DefaultListModel savings){
        Saving existe, saving;
        
        if (index != -1) {
            existe = control.getSaving(index);
            saving = view.modifySavingInput(existe);
            
            if (saving.getAmount() != 0) {
                control.modifierSaving(saving, index);
                savings.set(index, saving.toString());
            }     
        } else {
            view.showMessage();
        }
        
        updateSavingsTotal();
    }
    
    public void back(){
        view.dispose();
    }
    
    public double getTotalSavings(){
        return control.getTotalSavings();
    }
    
    public void updateSavingsTotal(){
        double amount = getTotalSavings();
        view.setTotalText(amount);
    }
    
}
