/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mac
 */

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Depense {
    private String description;
    private Date date;
    private double amount;

    public Depense(String description, Date date, double amount) {
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return description + " - " + new SimpleDateFormat("dd/mm/yyyy").format(date) + " - " + amount;
    }
    
    public Depense toDepense(String element){
        String[] parts = element.split(" - ");

        String desc = parts[0];
        LocalDate localDate = LocalDate.parse(parts[1], DateTimeFormatter.ofPattern("dd/mm/yyyy"));
        Date data = java.sql.Date.valueOf(localDate);
        double somme = Double.parseDouble(parts[2]);

        Depense depense = new Depense(desc, data, somme);

        return depense;
    }
    
    public boolean verifDepense(Depense depense){
        return (depense!=null || depense.getAmount()>0);
    }
}
