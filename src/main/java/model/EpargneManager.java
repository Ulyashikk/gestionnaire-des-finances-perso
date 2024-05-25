/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mac
 */
public class EpargneManager {
    private Saving[] savings = new Saving[100];
    private int nbSavings = 0;
    
    public void newSaving(String description, double amount){
        savings[nbSavings] = new Saving(description, amount);
        nbSavings++;
    }
    
    public Saving getSaving(int index){
        return savings[index];
    } 
    
    public double getTotalSaving(){
        double amount = 0;
        for (int i = 0; i< nbSavings; i++){
            amount+=savings[i].getAmount();
        }
        return amount;
    }
    
    public void deleteSaving(int num){
        for (int i = num; i< nbSavings-1; i++){
            savings[i]= savings[i+1];
        }
        nbSavings--;
    }
    
    public void modifierSaving(String description, double amount, int index){
        savings[index] = new Saving(description, amount);
    }
}
