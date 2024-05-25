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
public class DialogRevenuesWindow {
    
    private RevenuesWindow revenuesWindow;
    private RevenuesController revenuesControl;
    private RevenuesManager revenuesManager;
    
    public DialogRevenuesWindow(RevenuesWindow revenuesWindow){
        this.revenuesWindow = revenuesWindow;
        
        revenuesManager = new RevenuesManager();
        revenuesControl = new RevenuesController(revenuesManager, this);
    }
    
    public void addRevenue(DefaultListModel pastRevenues, DefaultListModel upcomingRevenues){
        Depense revenue = revenuesWindow.getNewRevenueInput(); 
        if (revenue.getDate().before(new Date()) && revenue.verifDepense(revenue)) {
            revenuesControl.ajouterRevenue(revenue);
            pastRevenues.addElement(revenue.toString());
        } else {
            upcomingRevenues.addElement(revenue.toString());
        }
        updateRevenueTotal();
    }
    
    public void deleteRevenue(int indexPast, int indexAvenir, 
            DefaultListModel pastRevenues, DefaultListModel upcomingRevenues){
        if (indexPast != -1) {
            revenuesControl.deleteRevenue(indexPast);
            pastRevenues.remove(indexPast);
        } else if (indexAvenir!=-1){
            upcomingRevenues.remove(indexAvenir);
        } else {
            revenuesWindow.showMessage();
        }
        updateRevenueTotal();
    }
    
    public void modifierRevenue(int indexPast, int indexAvenir, 
            DefaultListModel pastRevenues, DefaultListModel upcomingRevenues){
        Depense existe, revenue;
        
        if (indexPast != -1) {
            existe = revenuesControl.getRevenue(indexPast);
            revenue = revenuesWindow.modifyRevenueInput(existe);
            
            if (revenue != null && revenue.verifDepense(revenue)) {
                revenuesControl.modifierRevenue(revenue, indexPast);
                pastRevenues.set(indexPast, revenue.toString());
            }
        } else if (indexAvenir!=-1){
            existe = revenuesControl.getRevenue(indexAvenir);
            revenue = revenuesWindow.modifyRevenueInput(existe);
            
            if (revenue != null && revenue.verifDepense(revenue)) {
                upcomingRevenues.set(indexAvenir, revenue.toString());
            }
            
        } else {
            revenuesWindow.showMessage();
        }
        
        updateRevenueTotal();
    }
    
    public void back(){
        revenuesWindow.dispose();
    }
    
    public double getTotalRevenues(){
        return revenuesControl.getTotalRevenues();
    }
    
    public void updateRevenueTotal(){
        double amount = getTotalRevenues();
        revenuesWindow.setTotalText(amount);
    }
    
}
