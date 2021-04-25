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
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micha
 */
public class RemoveCarCommand implements Command{

    @Override
    public void execute(RMIUserInterface userService, RMICardInterface cardService, RMICarInterface carService) {
       // get the list of car objects available in the list and select the one to be deleted.
       Scanner input = new Scanner(System.in);
       
       //wrap in try-catch block for exceptuon handling 
       try{
           ArrayList<Car> listcars = new ArrayList<>();
           listcars = carService.listAllCars(); // get list of available cars
           int count = 1;//count objects in the list to keep record of available cars
           
           
           // iterate through cars to get details and select which to be deleted.
           for(Car  c: listcars){
               System.out.println("============================");
               System.out.println(count++);
               System.out.println(c.toString());
               System.out.println("==============================");
           }
           // make a choice of selecting which car to delete
           int choice = -1; //out of bound choice.
           while(choice <0 || choice > listcars.size()){
               try{
                   choice = input.nextInt(); // get the user choice input
                   
                   //catch wrong input such as string input or char instead of an integer
                   
               }catch(InputMismatchException ex){
                   System.out.println("Invalid or unavailable input , please try again");
                    input.nextInt(); // keep prompting until the right input is entered.
               }
           }
           // when user's choice is selected 
           boolean deleted = carService.removeCar(listcars.get(choice -1));  //get the selected choice thats is searched for, -1 to prevent getting out of bound
           
           //if the choice returns true
           if(deleted){
               System.out.println("car removed");
           }else{
               // if choice returns false
               System.out.println("soemthing went wrong!. Please try again");
           }
           
       } catch (RemoteException ex) {
            Logger.getLogger(RemoveCarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
