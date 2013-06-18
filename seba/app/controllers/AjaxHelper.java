package controllers;

import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

public class AjaxHelper extends Controller {
    
    @Before
    static void setConnectedUser()
    {
        if(Security.isConnected()) {
            User user =  (User)User.findAll().get(0);
            renderArgs.put("user", user);
        }
    }
    
    public static void menu(){
        User user = (User)User.findAll().get(0);
        renderTemplate("Navigation/menu.html");
        ok();
    }
}
