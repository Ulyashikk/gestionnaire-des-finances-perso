/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dialog.DialogRevenuesWindow;
import javax.swing.DefaultListModel;
import model.*;
import presentation.*;

/**
 *
 * @author mac
 */
public class RevenuesController {
    
    private RevenuesManager manager;
    private DialogRevenuesWindow dialog;

    public RevenuesController(RevenuesManager manager, DialogRevenuesWindow dialog) {
        this.manager = manager;
        this.dialog = dialog;
    }
    
    public void ajouterRevenue(Depense revenue){
        manager.newRevenue(revenue.getDescription(), revenue.getDate(), revenue.getAmount());
    }
    
    public void deleteRevenue(int numRevenue){
        manager.deleteRevenue(numRevenue);
    }
    
    public void modifierRevenue(Depense revenue, int numRevenue){
        manager.modifierRevenue(revenue.getDescription(), revenue.getDate(), revenue.getAmount(), numRevenue);
    }
    
    public double getTotalRevenues(){
        return manager.getTotalRevenue();
    }
    
    public Depense getRevenue(int numRevenue){
        return manager.getRevenue(numRevenue);
    }
}
