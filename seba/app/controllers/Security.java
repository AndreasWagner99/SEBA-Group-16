package controllers;

import models.User;

public class Security extends Secure.Security {

    static void onDisconnected() {
        Application.index();
    }
    
    static boolean authenticate(String username, String password) {
        User u = User.connection(username, password);
        if(u != null)
            return true;
        return false;
    }

    

}
