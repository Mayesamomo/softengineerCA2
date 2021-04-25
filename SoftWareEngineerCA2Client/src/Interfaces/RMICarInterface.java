/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Car;
import Models.Card;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author micha
 */
public interface RMICarInterface {
   //
    public boolean addCar(String username, Car c)throws RemoteException;
    public boolean editCar(String username, Car c)throws RemoteException;
    public boolean removeCar(Car c) throws RemoteException;
    
    public ArrayList listAllCars() throws RemoteException;
    public ArrayList listAllAvailableCar() throws RemoteException;
    public Car getSingleCar(String name, String model) throws RemoteException;
}
