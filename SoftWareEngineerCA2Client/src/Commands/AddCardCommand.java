/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Interfaces.RMICarInterface;
import Interfaces.RMICardInterface;
import Interfaces.RMIUserInterface;
import Models.Card;
import Models.Commons;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micha
 */
public class AddCardCommand implements Command {

    @Override
    public void execute(RMIUserInterface userService, RMICardInterface cardService, RMICarInterface carService) {
        Commons common = new Commons();
        Card card;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter card's owner name");
        String name = input.nextLine();

        System.out.println("Enter card number");
        int cardNumber = input.nextInt();

        System.out.println("Enter expiry date");
        String expDate = input.nextLine();

        System.out.println("enter CVC");
        String cvc = input.nextLine();

        card = new Card(name, cardNumber, expDate, cvc);
        
        try{
            boolean added = cardService.addCard(card);
            //validate entry
            if(added){
                System.out.println("card added");
            }
            else{
                System.out.println("Invalid card details");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(AddCardCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
