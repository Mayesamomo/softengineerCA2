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

/**
 *
 * @author micha
 */
public class LogoutCommand implements Command{

    /**
     *
     * @param userService
     * @param cardService
     * @param carService
     */
    @Override
    public void execute(RMIUserInterface userService, RMICardInterface cardService, RMICarInterface carService) {
 
        Commons.setLoggedIn(false);
        Commons.setUsername("");
        System.out.println("Logging out.");
    }
    
}
