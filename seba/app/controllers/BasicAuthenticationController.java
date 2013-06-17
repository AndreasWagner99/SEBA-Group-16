package controllers;

import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class BasicAuthenticationController extends Controller {

    @Before(priority=10)
    static void setConnectedUser()
    {
        if(Security.isConnected()) {
            User user =  (User)User.findAll().get(0);
            renderArgs.put("user", user);
        }
    }
}
