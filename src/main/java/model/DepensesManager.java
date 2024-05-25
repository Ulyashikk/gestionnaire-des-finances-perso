/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

public class DepensesManager {
    private Depense[] depenses = new Depense[1000];
    private int nbDepenses = 0;
    
    public void newDepense(String description, Date date, double amount){
        depenses[nbDepenses] = new Depense(description, date, amount);
        nbDepenses++;
    }
    
    public Depense getDepense(int index){
        return depenses[index];
    } 
    
    public double getTotalDepense(){
        double amount = 0;
        for (int i = 0; i< nbDepenses; i++){
            amount+=depenses[i].getAmount();
        }
        return amount;
    }
    
    public void deleteDepense(int numDepense){
        for (int i = numDepense; i< nbDepenses-1; i++){
            depenses[i]= depenses[i+1];
        }
        nbDepenses--;
    }
    
    public void modifierDepense(String description, Date date, double amount, int numDepense){
        depenses[numDepense] = new Depense(description, date, amount);
    }
}
