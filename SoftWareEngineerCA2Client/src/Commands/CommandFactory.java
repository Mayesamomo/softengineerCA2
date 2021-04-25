/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

/**
 *
 * @author micha
 */
public class CommandFactory {

    // instantiate  command factory 
    private static CommandFactory inst;

    public CommandFactory() {
    }

    //get the instance of the command factory
    public static CommandFactory getInstance() {
        synchronized (CommandFactory.class) {
            if (inst == null) {
                inst = new CommandFactory();
            }
        }
        return inst; //return whichever instance is selected or called

    }

    public static void setInst(CommandFactory inst) {
        CommandFactory.inst = inst;
    }

    //create commands 
    public Command createCommand(int choice) {
        Command c = null; // command is null at the start
        // using switch statement get user's choice of command to be sent 
        switch (choice) {
            case 0:
                c = new CloseClientCommand();
            case 1:
                c = new LoginCommand();
                break;
            case 2:
                c = new RegisterCommand();
                break;
            case 3: 
                c = new AddCarCommand();
                 break;
            case 4:
                c = new EditCarCommand();
                 break;
            case 5:
                c = new ListAllAvailableCar();
                 break;
            case 6:
                c = new ListAllCarsCommand();
                 break;
            case 7:
                c = new RemoveCarCommand();
                 break;
            case 8:
                c = new GetSingleCarCommand();
                 break;
            case 9:
                c = new AddCardCommand();
                 break;
            case 10:
                c = new EditCardCommand();
                 break;
            case 11: 
                c =new LogoutCommand();
                 break;
        }
        return c;
    }
}
