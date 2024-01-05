/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Validation {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    public static boolean isNumericDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumericInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidDate(String dateString, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            sdf.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static Date parse(String dateString) {
        try {
            Date date = dateFormat.parse(dateString);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean isValid(String data, String regex) {
        if (!data.trim().matches(regex)) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean isBoolean(String data) {
        try {
            Boolean.parseBoolean(data);
            return true;
            
        } catch(Exception e) {
            return false;
        }
    }
}
