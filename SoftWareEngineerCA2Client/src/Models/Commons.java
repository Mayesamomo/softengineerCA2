/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author micha
 */
public class Commons {

    private static boolean loggedIn;
    private static String userName;

    public Commons() {
        loggedIn = false;
        userName ="";
    }

//    static {
//        loggedIn = false;
//        userName = "";
//    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {

        Commons.loggedIn = loggedIn;
    }

    public static String getUsername() {
        return userName;
    }

    public static void setUsername(String username) {
        Commons.userName = username;
    }

}
