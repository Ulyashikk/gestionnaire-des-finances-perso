/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dialog.DialogEpargneWindow;
import model.Depense;
import model.EpargneManager;
import model.Saving;

/**
 *
 * @author mac
 */
public class EpargneController {
    
    private EpargneManager manager;
    private DialogEpargneWindow dialog;

    public EpargneController(EpargneManager manager, DialogEpargneWindow dialog) {
        this.manager = manager;
        this.dialog = dialog;
    }

    public void ajouterSaving(Saving saving) {
       manager.newSaving(saving.getName(), saving.getAmount());
    }

    public Saving getSaving(int index) {
        return manager.getSaving(index);
    }

    public double getTotalSavings() {
        return manager.getTotalSaving();
    }

    public void modifierSaving(Saving saving, int index) {
        manager.modifierSaving(saving.getName(),saving.getAmount(), index);
    }
}
