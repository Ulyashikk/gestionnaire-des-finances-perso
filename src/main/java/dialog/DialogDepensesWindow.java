/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialog;

import control.*;
import java.util.Date;
import javax.swing.DefaultListModel;
import model.*;
import presentation.*;

/**
 *
 * @author mac
 */
public class DialogDepensesWindow {
    
    private DepensesWindow view;
    private DepensesController control;
    private DepensesManager manager;
    
    public DialogDepensesWindow(DepensesWindow DepensesWindow){
        this.view = DepensesWindow;
        
        manager = new DepensesManager();
        control = new DepensesController(manager, this);
    }
    
    public void addRevenue(DefaultListModel pastDepenses, DefaultListModel upcomingDepenses){
        Depense depense = view.getNewDepenseInput(); 
        if (depense.getDate().before(new Date()) && depense.verifDepense(depense)) {
            control.ajouterDepense(depense);
            pastDepenses.addElement(depense.toString());
        } else {
            upcomingDepenses.addElement(depense.toString());
        }
        updateRevenueTotal();
    }
    
    public void deleteRevenue(int indexPast, int indexAvenir, 
            DefaultListModel pastDepenses, DefaultListModel upcomingDepenses){
        if (indexPast != -1) {
            control.deleteDepense(indexPast);
            pastDepenses.remove(indexPast);
        } else if (indexAvenir!=-1){
            upcomingDepenses.remove(indexAvenir);
        } else {
            view.showMessage();
        }
        updateRevenueTotal();
    }
    
    public void modifierRevenue(int indexPast, int indexAvenir, 
            DefaultListModel pastDepenses, DefaultListModel upcomingDepenses){
        Depense existe, revenue;
        
        if (indexPast != -1) {
            existe = control.getDepense(indexPast);
            revenue = view.modifyDepenseInput(existe);
            
            if (revenue != null && revenue.verifDepense(revenue)) {
                control.modifierDepense(revenue, indexPast);
                pastDepenses.set(indexPast, revenue.toString());
            }
        } else if (indexAvenir!=-1){
            existe = control.getDepense(indexAvenir);
            revenue = view.modifyDepenseInput(existe);
            
            if (revenue != null && revenue.verifDepense(revenue)) {
                upcomingDepenses.set(indexAvenir, revenue.toString());
            }
            
        } else {
            view.showMessage();
        }
        
        updateRevenueTotal();
    }
    
    public void back(){
        view.dispose();
    }
    
    public double getTotalDepenses(){
        return control.getTotalDepenses();
    }
    
    public void updateRevenueTotal(){
        double amount = getTotalDepenses();
        view.setTotalText(amount);
    }
    
}
