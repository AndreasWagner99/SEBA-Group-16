package controllers;

import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class AjaxHelper extends BasicAuthenticationController {
    
    public static void menu(){
        User user = (User)User.findAll().get(0);
        renderTemplate("Registration/menu.html", user);
        ok();
    }
}
