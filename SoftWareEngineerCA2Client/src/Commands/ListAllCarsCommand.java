/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Interfaces.RMICarInterface;
import Interfaces.RMICardInterface;
import Interfaces.RMIUserInterface;
import Models.Car;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micha
 */
public class ListAllCarsCommand implements Command {

    @Override
    public void execute(RMIUserInterface userService, RMICardInterface cardService, RMICarInterface carService) {
        //get the list of all available cars

//wrap in try catch to for exception handling
        try {
            ArrayList<Car> listcars;
            listcars = new ArrayList<>();
            listcars = carService.listAllCars();

            int count = 1; //count the object in the list
            //iterate through list and get details of each objec
            for (Car c : listcars) {
                System.out.println("================================================");
                System.out.println(count++); //increment 
                System.out.println("Name: " + c.getName());
                System.out.println("Make: " + c.getMake());
                System.out.println("Model: " + c.getModel());
                System.out.println("Manufacted Date: " + c.getManufacturedDate());
                System.out.println("Horse Power: " + c.getHousePower());
                System.out.println("Number of Door: " + c.getDoor());
                System.out.println("Bought by: " + c.getBoughtBy());
                System.out.println("isAvailable?: " + c.isIsAvailable());

            }

        } catch (RemoteException ex) {
            Logger.getLogger(ListAllAvailableCar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
