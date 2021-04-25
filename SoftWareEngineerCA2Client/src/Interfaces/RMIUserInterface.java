/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Models.User;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author micha
 */
public interface RMIUserInterface  extends Remote{
    // user interface that deals with the user request such as registeration and authentication
    public boolean register(User u) throws RemoteException;
    public boolean login(User u) throws RemoteException;
}
