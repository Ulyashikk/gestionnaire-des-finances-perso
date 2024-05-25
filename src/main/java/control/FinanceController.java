/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Budget;
import presentation.*;

public class FinanceController {
    private Budget budget;
    private FinanceWindow mainView;
    private RevenuesWindow revenueView;
    private DepensesWindow depenseView;
    private EpargneWindow epargneView;

    public FinanceController(FinanceWindow mainView) {
        this.budget = new Budget(mainView.getBudget());
        this.mainView = mainView;
        revenueView = new RevenuesWindow(this);
        depenseView = new DepensesWindow(this);
        epargneView = new EpargneWindow(this);
    }

    public void showExpensesWindow() {
        mainView.setVisible(false);
        depenseView.setVisible(true);
        updateMainView();
    }

    public void showRevenuesWindow() {
        mainView.setVisible(false);
        revenueView.setVisible(true);
        updateMainView();
    }

    public void showSavingsWindow() {
        mainView.setVisible(false);
        epargneView.setVisible(true);
        updateMainView();
    }
    
    public void setVisibleMainView(){
        updateMainView();
        mainView.setVisible(true);
    }
    
    public void nextMonth() {
        budget.nextMonth();
        updateMainView();
    }

    public void previousMonth() {
        budget.previousMonth();
        updateMainView();
    }

    public void setNewBudget(double newBudget) {
        budget.setMonthlyBudget(newBudget);
        updateMainView();
    }
    
    public double getRevenues(){
        return revenueView.getTotalRevenues();
    }
    
    public double getDepenses(){
        return depenseView.getTotalDepenses();
    }
    
    public double getReste(){
        return budget.getMonthlyBudget() - getDepenses();
    }
    
    public double getSavings(){
        return epargneView.getTotalSavings();
    }
    

    public void updateMainView() {
        mainView.updateBudgetInfo(mainView.getBudget(), getDepenses(), getRevenues(), getSavings());
    }
}

