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
import Models.Commons;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micha
 */
public class EditCarCommand implements Command{

    /**
     *
     * @param userService
     * @param cardService
     * @param carService
     */
    @Override
    public void execute(RMIUserInterface userService, RMICardInterface cardService, RMICarInterface carService) {
        Commons common = new Commons();
        Car cars;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter car's name");
        String name = input.nextLine();
        
        System.out.println("Enter car's Model");
        String model = input.nextLine();

        System.out.println("Enter car's make");
        String make = input.nextLine();
        
        System.out.println("Enter car's Manufacture date");
        String manufacturedDate = input.nextLine();
        
        System.out.println("how many horse power does the car have?");
        int horsepower = input.nextInt();
        
        System.out.println("number of doors car has");
        int door = input.nextInt();
        
        System.out.println("Car is bought by? ");
        String boughtBy = input.nextLine();
        
        System.out.println("is the car still in stock?");
        boolean isAvailable = input.nextBoolean();
        
          cars = new Car(name,model, make, manufacturedDate,horsepower,  door, boughtBy,isAvailable);
          
          try{
              cars.setName(name);
              cars.setModel(model);
              cars.setMake(make);
              cars.setManufacturedDate(manufacturedDate);
              cars.setHousePower(horsepower);
              cars.setDoor(door);
              cars.setBoughtBy(boughtBy);
              cars.setIsAvailable(isAvailable);
              boolean edited = carService.editCar(common.getUsername(), cars);
              if(edited){
                  System.out.println("edited details saved"); //if car detail is successfully saved
              }
              else{
                  System.out.println("something went wrong")
                          ;}
          } catch (RemoteException ex) {
            Logger.getLogger(EditCarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
