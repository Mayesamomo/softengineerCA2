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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micha
 */
public class GetSingleCarCommand implements Command {

    //get a single car using the name and model name to retrieve it
    @Override
    public void execute(RMIUserInterface userService, RMICardInterface cardService, RMICarInterface carService) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter car name");
        String name = input.nextLine();

        System.out.println("Enter car model");
        String model = input.nextLine();

        //wrap in try catch block for exception handling
        try {
            Car c = carService.getSingleCar(name, model);
            if (c == null) {
                System.out.println("car does not exist");
            } else {
                System.out.println("============================================");
                System.out.println("Name: " + c.getName());
                System.out.println("Make: " + c.getMake());
                System.out.println("Model: " + c.getModel());
                System.out.println("Manufacted Date: " + c.getManufacturedDate());
                System.out.println("Horse Power: " + c.getHousePower());
                System.out.println("Number of Door: " + c.getDoor());
                boolean isAvailable = c.isIsAvailable();
                System.out.println("is Available?: " +isAvailable);
                System.out.println("============================================");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GetSingleCarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
