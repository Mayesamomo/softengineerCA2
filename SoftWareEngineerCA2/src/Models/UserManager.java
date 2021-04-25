/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Interfaces.RMIUserInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author micha
 */
public class UserManager extends UnicastRemoteObject implements RMIUserInterface{

    // serves as the proxy that handles user's requests 
    private final HashMap<String, User> users = new HashMap<>();

    public UserManager() throws RemoteException {
    }
    
    
    
    @Override
    public boolean register(User u) throws RemoteException {
        //synchronized handles multiple request coming in at thesame time
    synchronized (users) {
            if (u != null) { // if the user's input are not empty 
                if (!users.containsKey(u.getUsername())) { // and user is not already registered. i.e stored in the map 
                    users.put(u.getUsername(), u); //register user(out user in the map)
                    return true;
                }
            }
            return false; //any other possible outcome should return false
        }
    }

    @Override
    public boolean login(User u) throws RemoteException {
        //can handle multiple request
        synchronized (users) {
            if (users.containsKey(u.getUsername())) { //check if the key exist in the map
                if (users.get(u.getUsername()).getPassword().equals(u.getPassword())) { // if key exists retreve it with the values
                    return true;
                }
            }
            return false;
        }
    }
    
}
