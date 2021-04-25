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
public class LoginCommand implements Command{

    @Override
    public void execute(RMIUserInterface userService, RMICardInterface cardService, RMICarInterface carService) {

        System.out.println("Login Chosen");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Username:");
        String username = input.nextLine();
        
        System.out.println("Enter password:");
        String password = input.nextLine();
        
        User u = new User(username,password);
        
        try {
            boolean loginStatus = userService.login(u);
            if(loginStatus){
                System.out.println("Logged in!");
                System.out.println("Welcome " + username);
                Commons.setLoggedIn(true);
                Commons.setUsername(username);
            }else{
                System.out.println("Login failed.");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
