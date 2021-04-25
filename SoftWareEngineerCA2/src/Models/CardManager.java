/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Interfaces.RMICardInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author micha
 */
public class CardManager extends UnicastRemoteObject implements RMICardInterface{
  private final HashMap<Integer, Card> cards = new HashMap<>();

    public CardManager() throws RemoteException {
    }
 

    @Override
    public boolean editCard(Card c) throws RemoteException {
        //edit existing card
        synchronized (cards) { 
            if (c!= null){ //confirm the card input first, sanitize inputs
                if (!cards.containsKey(c.getNumber())) {
                    c.setName(c.getName());
                    c.setNumber(c.getNumber());
                    c.setExpDate(c.getExpDate());
                    c.setCvc(c.getCvc());
                    //set the values
                    cards.put(c.getNumber(), c); // update dates using the key 
                    return true;
                }
                
            }
            return false;
        }
    }

    @Override
    public boolean addCard(Card c) throws RemoteException {
      //check if card is already saved and
        synchronized (cards) { 
            if (c!= null){ //confirm the card input first 
                if (!cards.containsKey(c.getNumber())) {
                    cards.put(c.getNumber(),c);
                    return true;
                }
                else if(cards.containsKey(c.getNumber())) {
                    System.out.println("You already saved this card's details");
                    return true;
                }
            }
            return false;
        }
    }
    
}
