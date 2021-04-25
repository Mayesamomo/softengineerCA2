/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Interfaces.RMICarInterface;
import Interfaces.RMICardInterface;
import Interfaces.RMIUserInterface;

/**
 *
 * @author micha
 */
public class CloseClientCommand implements Command {

    public CloseClientCommand() {
    }

    @Override
    public void execute(RMIUserInterface userService, RMICardInterface cardService, RMICarInterface carService) {
        System.out.println("Adeu, i que te vagi be!");
    }
    
}
