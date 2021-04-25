/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Interfaces.RMICarInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author micha
 */
public class CarManager extends UnicastRemoteObject implements RMICarInterface {

    private final ArrayList<Car> listcars;
    private final Car cars;
    User user;

    public CarManager() throws RemoteException {
        this.cars = new Car();
        this.listcars = new ArrayList<>();

    }

    @Override
    public boolean addCar(String username, Car c) throws RemoteException {
        if (listcars.contains(c)) {
            return false;
        } else {
            listcars.add(c);
        }
        return false;
    }

    @Override
    public boolean editCar(String username, Car c) throws RemoteException {
        if (listcars.contains(c)) {
            if (username.contains(user.getUsername())) {
                Car edited = new Car();
                edited.setName(c.getName());
                edited.setModel(c.getModel());
                edited.setMake(c.getMake());
                edited.setManufacturedDate(c.getManufacturedDate());
                edited.setHousePower(c.getHousePower());
                edited.setDoor(c.getDoor());
                edited.setBoughtBy(username);
                edited.setIsAvailable(c.isIsAvailable());
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean removeCar(Car c) throws RemoteException {
        try {
            if (listcars.contains(c)) {
                listcars.remove(c);
            }
        } catch (Exception ex) {
            System.out.println("Exception occurred!" + ex);
        }
        return false;
    }

    @Override
    public ArrayList listAllCars() throws RemoteException {

        if (listcars != null) {
            return listcars;
        }
        return null;
    }

    @Override
    public ArrayList listAllAvailableCar() throws RemoteException {
        if (cars.isIsAvailable() == true) {
            return cars.ListAllAvailableCars();
        }
        return null;

    }

    @Override
    public Car getSingleCar(String name, String model) throws RemoteException {
        for (Car car : listcars) {
            if (car.getName().equalsIgnoreCase(model) && car.getModel().equalsIgnoreCase(model)) {
                return car;
            }
        }
        return null;
    }

}
