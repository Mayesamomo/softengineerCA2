/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author micha
 */
public class Car {

    private String name;
    private String model;
    private String make;
    private String ManufacturedDate;
    private int housePower;
    private int door;
    private String boughtBy;
    private boolean isAvailable;

    public Car() {
    }

    public Car(String name, String model, String make, String ManufacturedDate, int housePower, int door, String boughtBy, boolean isAvailable) {
        this.name = name;
        this.model = model;
        this.make = make;
        this.ManufacturedDate = ManufacturedDate;
        this.housePower = housePower;
        this.door = door;
        this.boughtBy = boughtBy;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getManufacturedDate() {
        return ManufacturedDate;
    }

    public void setManufacturedDate(String ManufacturedDate) {
        this.ManufacturedDate = ManufacturedDate;
    }

    public int getHousePower() {
        return housePower;
    }

    public void setHousePower(int housePower) {
        this.housePower = housePower;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public String getBoughtBy() {
        return boughtBy;
    }

    public void setBoughtBy(String boughtBy) {
        this.boughtBy = boughtBy;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.model);
        hash = 53 * hash + Objects.hashCode(this.make);
        hash = 53 * hash + Objects.hashCode(this.ManufacturedDate);
        hash = 53 * hash + this.housePower;
        hash = 53 * hash + this.door;
        hash = 53 * hash + Objects.hashCode(this.boughtBy);
        hash = 53 * hash + (this.isAvailable ? 1 : 0);
        return hash;
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
        final Car other = (Car) obj;
        if (this.housePower != other.housePower) {
            return false;
        }
        if (this.door != other.door) {
            return false;
        }
        if (this.isAvailable != other.isAvailable) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.make, other.make)) {
            return false;
        }
        if (!Objects.equals(this.ManufacturedDate, other.ManufacturedDate)) {
            return false;
        }
        if (!Objects.equals(this.boughtBy, other.boughtBy)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" + "name=" + name + ", model=" + model + ", make=" + make + ", ManufacturedDate=" + ManufacturedDate + ", housePower=" + housePower + ", door=" + door + ", boughtBy=" + boughtBy + ", isAvailable=" + isAvailable + '}';
    }

    //list cars
    public ArrayList ListAllAvailableCars() {
        ArrayList<Car> cars = new ArrayList<>();
       if(isAvailable ==true){
            cars.forEach((c) -> {
            cars.add(c);
        });
       }
        return cars;
    }

    //list all 
}
