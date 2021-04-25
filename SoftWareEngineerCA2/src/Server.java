
import Models.CarManager;
import Models.CardManager;
import Models.UserManager;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author micha
 */
public class Server {

    public static void main(String[] args) {
        try {

            int port = 5099;
            startRegistry(port); //insert port into the registry server  to be started on it.
            UserManager userService = new UserManager();
            CardManager cardService = new CardManager();
            CarManager carService = new CarManager();

            String registryPath = "rmi://localhost:" + port; //setup the part  for the registry connection . part set to localhost
            String userServicePath = "/UserService";
            String cardServicePath = "/CardService";
            String carServicePath = "/CarService";

            System.out.println("Binding Services...");

            //bind the  services to resppective class objects
            Naming.rebind(registryPath + userServicePath, cardService);
            Naming.rebind(registryPath + cardServicePath, userService);
            Naming.rebind(registryPath + carServicePath, carService);

            System.out.println("Services are ready.");

        } catch (RemoteException | MalformedURLException ex) {
            System.exit(-1);
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //registery starter takes in the port number
    private static void startRegistry(int RMIport) throws RemoteException {
        try {

            Registry registry;
            registry = LocateRegistry.createRegistry(RMIport);
            System.out.println("RMI registry is running on port: " + RMIport);
            //Registry registry = LocateRegistry.getRegistry(RMIport); // factorial class locate 
            //registry.list(); // the regitery port 

        } catch (RemoteException ex) {
            System.exit(-1);
            System.out.println("RMI registry created at port " + RMIport);
        }
    }
}
