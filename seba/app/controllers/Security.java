package controllers;

import java.util.Date;

import play.data.validation.Required;
import play.libs.Crypto;
import play.libs.Time;
import models.User;

public class Security extends Secure.Security {

    static void onDisconnected() {
        Application.index();
    }
    
    static void onAuthenticated(){
        if(request.isAjax())
            ok();
    }
    
    static boolean authenticate(String username, String password) {
        User u = User.connection(username, password);
        if(u != null)
            return true;

        if(request.isAjax())
            forbidden();

        return false;
    }

}
