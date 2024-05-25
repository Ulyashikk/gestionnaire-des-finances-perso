/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author mac
 */
public class Saving {
    private String name;
    private double amount;

    public Saving(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return name + " : " + amount;
    }
    
    public Saving toSaving(String element){
        String[] parts = element.split(" : ");

        String name = parts[0];
        double somme = Double.parseDouble(parts[1]);

        Saving saving = new Saving(name, somme);

        return saving;
    }
}
