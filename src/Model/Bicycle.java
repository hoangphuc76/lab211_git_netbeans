/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Bicycle {
    private String code;
    private int speed;
    private double distance;
    private boolean isElectricBicycle;

    public Bicycle(String code, int speed, double distance, boolean isElectricBicycle) {
        this.code = code;
        this.speed = speed;
        this.distance = distance;
        this.isElectricBicycle = isElectricBicycle;
    }

    public Bicycle(String code) {
        this.code = code;
    }
    
    public String needToRecharge() {
        if (distance > 60)
            return "Need to recharge batteries";
        else 
            return "Don't need to recharge";
    }
    public double getTimeToMove() {
        return (double) (distance / speed);
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isIsElectricBicycle() {
        return isElectricBicycle;
    }

    public void setIsElectricBicycle(boolean isElectricBicycle) {
        this.isElectricBicycle = isElectricBicycle;
    }
    
    @Override
    public String toString() {
        if (isElectricBicycle) 
             return "E-Bicycle" + "     |" + code + "   |" + speed + "  |" + distance + "   |" + needToRecharge();
        else 
            return "Bicycle" + "    |" + code + "   |" + speed + "  |" + distance + "   |" + needToRecharge();
        
    }

 

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bicycle other = (Bicycle) obj;
        return Objects.equals(this.code, other.code);
    }
    
    
}
