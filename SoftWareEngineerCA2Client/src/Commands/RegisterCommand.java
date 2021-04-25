/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Interfaces.RMICarInterface;
import Interfaces.RMICardInterface;
import Interfaces.RMIUserInterface;
import Models.Commons;
import Models.User;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micha
 */
public class RegisterCommand implements Command {

    @Override
    public void execute(RMIUserInterface userService, RMICardInterface cardService, RMICarInterface carService) {
        // Commons common = new Commons(); //common utils class referenced
        boolean regStatus;
        System.out.println();
        Scanner input = new Scanner(System.in); // scan user inputs
        System.out.println("Enter Username:");
        String username = input.nextLine(); //take in the input parsed

        System.out.println("Enter password:");
        String password = input.nextLine();

        User u = new User(username, password); //create new user obj
        try {

            regStatus = userService.register(u);

            if (regStatus) { //if the register method returns true
                System.out.println("Account created!");
                Commons.setLoggedIn(true); //set isLoggedIn to true 
                Commons.setUsername(username); //set username 

            } else if (regStatus && u.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Account not created. Username may already be in use.");
            } else {
                System.out.println("Something went wrong.");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
