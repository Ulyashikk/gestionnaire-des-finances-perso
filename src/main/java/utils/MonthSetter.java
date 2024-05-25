/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author mac
 */
public class MonthSetter {
    
    private static String currentMonth;

    static {
        updateMonth();
    }

    public static void updateMonth() {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.getDefault());
        currentMonth = capitalizeFirstLetter(monthFormat.format(new Date()));
    }

    public static String getCurrentMonth() {
        return currentMonth;
    }
    
    public static String getPreviousMonth() {
        return null;
    }
    
    public static String getNextMonth() {
        return null;
    }

    private static String capitalizeFirstLetter(String month) {
        if (month == null || month.isEmpty()) {
            return month;
        }
        return month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();
    }
    
}
