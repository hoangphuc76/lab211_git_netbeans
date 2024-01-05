/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Inputter {

    private static final String DATE_FORMAT = "yyyy/MM/dd";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public static double getDoubleFromInput(String name) {
        Scanner sc = new Scanner(System.in);
        double number;
        while (true) {
            System.out.print(String.format("Enter %s: ", name));
            try {
                number = sc.nextDouble();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the double number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter the double number > 0 ");
                sc.next();
            }
        }
    }

    public static int getIntFromInput(String name) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("Enter %s: ", name));
            try {
                number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter the integer number > 0 ");
                sc.next();
            }
        }
    }

    public static Date getDateFromInput(String name) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(String.format("Enter %s: ", name));
            String dateString = sc.nextLine();
            if (!dateString.isEmpty()) {
                try {
                    Date date = dateFormat.parse(dateString);
                    return date;
                } catch (ParseException e) {
                    System.err.println(String.format("Invalid date format. Please enter again (%s).", DATE_FORMAT));
                }
            }
        }
    }

    public static String getStringFromInput(String name) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("Enter %s: ", name));
            s = sc.nextLine();
        }
        return s;
    }

    public static String inputPatter(String name, String pattern) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        do {
            System.out.print(String.format("Enter %s: ", name));
            s = sc.nextLine();
        } while (s == null || s.isEmpty() || !s.matches(pattern));
        return s;
    }

    public static boolean inputBoolean(String name) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(String.format("Enter %s: ", name));
            try {
                boolean number = sc.nextBoolean();
                return number;
            } catch (InputMismatchException e) {
                System.err.println("Only enter the double number > 0 ");
                sc.next();
            }
        }
    }

}
