/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.Card;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author micha
 */
public interface RMICardInterface extends Remote{
    public boolean addCard(Card c) throws RemoteException;
    public boolean editCard(Card c) throws RemoteException;
    
}
