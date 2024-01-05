/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.Inputter;
import View.Validation;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author LENOVO
 */
public class Bi_Store {

    private List<Bicycle> biList = new ArrayList<>();

    public void loadData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("InputFile.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                if (arr.length == 4) {
                    boolean isCode = Validation.isValid(arr[0], "B[0-9]{1,}"),
                            isSpeed = Validation.isNumericInt(arr[1].trim()),
                            isDistance = Validation.isNumericDouble(arr[2].trim()),
                            isElectric = Validation.isBoolean(arr[3].trim());
                    if (isCode && isSpeed && isDistance && isElectric) {
                        String code = arr[0];
                        int speed = Integer.parseInt(arr[1].trim());
                        double distance = Double.parseDouble(arr[2].trim());
                        boolean isElectricBicycle = Boolean.parseBoolean(arr[3].trim());
                        Bicycle bicycle = new Bicycle(code, speed, distance, isElectricBicycle);
                        biList.add(bicycle);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void deleteBicycle(String code) {
        boolean removed = biList.removeIf(v -> v.getCode().equals(code));
        if (removed) {
            System.err.println("Bicycle deleted successfully.");
        } else {
            System.err.println("Bicycle not found.");
        }

    }

    public void addBiCyCle(String code, int speed, double distance, boolean isElectricBicycle) {
        Bicycle bicycle = new Bicycle(code, speed, distance, isElectricBicycle);
        biList.add(bicycle);
    }

    public List<Bicycle> getBiList() {
        return biList;
    }


    public List search(double min) {
        Predicate<Bicycle> biPre = u -> (u.getTimeToMove() == min);
        List<Bicycle> searchList = biList.stream().filter(biPre).collect(Collectors.toList());
        return searchList;

    }
}
