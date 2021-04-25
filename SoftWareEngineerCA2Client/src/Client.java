
import Commands.Command;
import Commands.CommandFactory;
import Interfaces.RMICarInterface;
import Interfaces.RMICardInterface;
import Interfaces.RMIUserInterface;
import Models.Commons;
import java.net.MalformedURLException;
import java.rmi.Naming;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.Scanner;
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
public class Client {

    public static RMIUserInterface UserService;
    public static RMICarInterface CarService;
    public static RMICardInterface CardService;

    public static void main(String[] args) throws NotBoundException {

        // wrapp in try-catch  block
        try {
            Commons common = new Commons(); //instantiate the common utils class
            int port = 5099; //port number of server to look for

            //define the route path to look for on the server 
            String registryPath = "rmi://localhost:" + port; //setup the part  for the registry connection . part set to localhost
            String userServicePath = "/UserService";
            String cardServicePath = "/CardService";
            String carServicePath = "/CarService";

            //cast Remote into respective RMI object
            UserService = (RMIUserInterface) Naming.lookup(registryPath + userServicePath);
            CarService = (RMICarInterface) Naming.lookup(registryPath + carServicePath);
            CardService = (RMICardInterface) Naming.lookup(registryPath + cardServicePath);

            //get the instance of command factory for choices selection
            CommandFactory factory = CommandFactory.getInstance();
            Command c; //instantiate command obj 
            Scanner kboard = new Scanner(System.in); // using the scanner option to get user input

            //get user's details beofre they can make a selection, authenticate who makes chocie
            int choice = -1;
            while (choice != 0) { //while the choice os not 0
                //get the methods dealing with auth choices
                choice = chooseUserMenu(kboard);

                // using switch select a chocie option
                switch (choice) {
                    case 1:
                        //authenticate user
                        c = factory.createCommand(1);
                        c.execute(UserService, CardService, CarService); // execute the appropiate service call
                        break;
                    case 2:
                        //sign up assign new auth to unauthenticated user
                        c = factory.createCommand(2);
                        c.execute(UserService, CardService, CarService);
                        break;
                    case 0:
                        //close the client connection
                        c = factory.createCommand(0);
                        c.execute(UserService, CardService, CarService);
                        break;
                }
                // now, check if there is a logged in user and grant access to the restricted menu option
                if (common.isLoggedIn()) {
                    // get access to card service and peform required command
                    int authenticatedChoice = -1;
                    while (authenticatedChoice != 0) {
                        authenticatedChoice = carMenuOption(kboard);
                        switch (authenticatedChoice) {
                            case 1:
                                //option one add car
                                c = factory.createCommand(3);
                                c.execute(UserService, CardService, CarService); // execute the appropiate service call
                                break;
                            case 2:
                                //option 2 edit car
                                c = factory.createCommand(4);
                                c.execute(UserService, CardService, CarService); // execute the appropiate service call
                                break;
                            case 3:
                                c = factory.createCommand(5);
                                c.execute(UserService, CardService, CarService); // execute the appropiate service call
                                break;
                            case 4:
                                c = factory.createCommand(6);
                                c.execute(UserService, CardService, CarService); // execute the appropiate service call
                                break;
                            case 5:
                                c = factory.createCommand(7);
                                c.execute(UserService, CardService, CarService); // execute the appropiate service call
                                break;

                            case 6:
                                c = factory.createCommand(8);
                                c.execute(UserService, CardService, CarService); // execute the appropiate service call
                                break;
                            case 0:
                                //close the client connection
                                c = factory.createCommand(9);
                                c.execute(UserService, CardService, CarService);
                                break;
                        }
                    }
                }

                if (common.isLoggedIn()) {
                    // get access to card service and peform required command
                    int authenticatedChoice = -1;
                    while (authenticatedChoice != 0) {
                        authenticatedChoice = cardChoiceMenu(kboard);
                        switch (authenticatedChoice) {
                            case 1:
                                //option one add card
                                c = factory.createCommand(10);
                                c.execute(UserService, CardService, CarService); // execute the appropiate service call
                                break;
                            case 2:
                                //option 2 edit card
                                c = factory.createCommand(11);
                                c.execute(UserService, CardService, CarService); // execute the appropiate service call
                                break;
                            case 0:
                                //close the client connection
                                c = factory.createCommand(12);
                                c.execute(UserService, CardService, CarService);
                                break;
                        }
                    }
                }

            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int chooseUserMenu(Scanner input) {
        System.out.println("===============================================");
        int choice = -1;
        while (choice < 0 || choice > 2) {
            //display chocie the user has 
            System.out.println("Please decide what to do");
            System.out.println("1" + "Sign in");
            System.out.println("2" + "sign up");
            System.out.println("0" + "Exit!");

            // get the choice input and filter for error
            try {
                choice = input.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("invalid selection, please select appropiate menu option" + e.getMessage());
                input.nextLine(); // propmpt again
            }

        }
        input.nextLine();
        System.out.println("===========================================");
        return choice;
    }

    public static int cardChoiceMenu(Scanner input) {
        System.out.println("=============================================");
        int choice = -1;
        while (choice < 0 || choice > 2) {
            System.out.println("Please select an option");
            System.out.println("1" + "add card");
            System.out.println("2" + "edit card");
            System.out.println("0" + "exit");

            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("invalid selection, please select appropiate menu option" + e.getMessage());
                input.nextLine(); // propmpt again
            }
        }
        input.nextLine();
        System.out.println("===========================================");
        return choice;
    }

    public static int carMenuOption(Scanner input) {
        System.out.println("=============================================");
        int choice = -1;
        while (choice < 0 || choice > 6) {
            System.out.println("Please select an option");
            System.out.println("1" + "add car");
            System.out.println("2" + "editcar");
            System.out.println("3" + "list available cars");
            System.out.println("4" + "list all cars");
            System.out.println("5" + "get a single car");
            System.out.println("6" + "delete car");
            System.out.println("0" + "exit");
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("invalid selection, please select appropiate menu option" + e.getMessage());
                input.nextLine(); // propmpt again
            }
        }
        input.nextLine();
        System.out.println("===========================================");
        return choice;
    }
}
