/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bi_Store;
import Model.Bicycle;
import View.Inputter;
import View.Menu;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class StoreManagement extends Menu {

    private Bi_Store bi_Store = new Bi_Store();
    private List<Bicycle> storeList = bi_Store.getBiList();

    public StoreManagement() {
        super("BICYCLE MANAGEMENT SYSTEM", new String[]{
            "List all", "Add new bicycle", "Delete a bicycle", "Searching the least time to move", "Exit"
        });
    }

    @Override
    public void execute(int choice) {
        double min = 0;

        switch (choice) {

            case 1:
                bi_Store.loadData();
                displayAll(storeList);
                break;
            case 2:
                doAddBicycle();
                break;
            case 3:
                doDeleteBicycle();
                break;
            case 4:
                for (Bicycle bi : storeList) {
                    if (bi.getTimeToMove() < min) {
                        min = (double) bi.getTimeToMove();
                    }
                }
                displayAll(bi_Store.search(min));
                break;
            case 5:
                System.out.println("Bye!");
                break;
        }
    }

    private void doAddBicycle() {
        System.err.println("\nAdd a Vaccine");
        String code = Inputter.inputPatter("Bicycle code", "B[0-9]{1,}");
        Bicycle bi = new Bicycle(code);
        if (!storeList.contains(bi)) {
            int speed = Inputter.getIntFromInput("Bicycle speed");
            double distance = Inputter.getDoubleFromInput("distance");
            boolean isElectricBicycle = Inputter.inputBoolean("is Electric Bicycle?");
            bi_Store.addBiCyCle(code, speed, distance, isElectricBicycle);
        } else {
            System.err.println("Bicycle is exist in the list");
        }
        displayAll(storeList);

    }

    private void doDeleteBicycle() {
        Scanner scanner = new Scanner(System.in);
        System.err.println("\nDelete a Bicycle by code");
        System.out.print("Enter the code of the Bicycle to delete: ");
        String code = scanner.nextLine();
        bi_Store.deleteBicycle(code);
        displayAll(storeList);
    }

    private void displayAll(List<Bicycle> list) {
        System.out.println("LIST BICYCLE");
        System.out.println("-----------------------------");
        if (list.size() == 0) {
            System.out.println("Empty List");
        } else {
            Collections.sort(list, (o1, o2) -> (o1.getSpeed() < o2.getSpeed()) ? -1 : (o1.getSpeed() == o2.getSpeed()) ? 0 : 1);
            for (Bicycle bicycle : list) {
                System.out.println(bicycle.toString());
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Total: " + list.size());
    }

    public static void main(String[] args) {
        StoreManagement storeManagement = new StoreManagement();
        storeManagement.run();
    }
}
