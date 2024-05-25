/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

/**
 *
 * @author mac
 */
public class RevenuesManager {
    private Depense[] revenues = new Depense[100];
    private Depense[] revenuesAvenir =  new Depense[100];
    private int nbRevenues = 0;
    private int nbRevenuesAvenir = 0;
    
    public void newRevenue(String description, Date date, double amount){
        revenues[nbRevenues] = new Depense(description, date, amount);
        nbRevenues++;
    }
    
    public Depense getRevenue(int index){
        return revenues[index];
    } 
    
    public double getTotalRevenue(){
        double amount = 0;
        for (int i = 0; i< nbRevenues; i++){
            amount+=revenues[i].getAmount();
        }
        return amount;
    }
    
    public void deleteRevenue(int numRevenue){
        for (int i = numRevenue; i< nbRevenues-1; i++){
            revenues[i]= revenues[i+1];
        }
        nbRevenues--;
    }
    
    public void modifierRevenue(String description, Date date, double amount, int numRevenue){
        revenues[numRevenue] = new Depense(description, date, amount);
    }
}
