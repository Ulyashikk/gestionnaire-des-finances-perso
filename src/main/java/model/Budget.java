/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Budget {
    private double monthlyBudget;
    private Depense expenses;
    private Depense revenues;
    private double savings;

    public Budget(double initialBudget) {
        this.monthlyBudget = initialBudget;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public double getTotalRevenues() {
        return revenues.getAmount();
    }
    
    public double getTotalExpenses() {
        return expenses.getAmount();
    }

    public double getTotalSavings() {
        return savings;
    }

    public double getRemainingBudget() {
        return monthlyBudget - getTotalExpenses();
    }

    public void nextMonth() {
        // Логика для перехода на следующий месяц
    }

    public void previousMonth() {
        // Логика для возвращения к предыдущему месяцу
    }
}
