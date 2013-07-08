package controllers;

import models.Company;
import models.Designer;
import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

public class AjaxHelper extends BasicController {
    
    public static void menu(){
        renderTemplate("Navigation/menu.html");
        ok();
    }
    
    public static void extensions(){
        renderTemplate("Extensions/extension.html");
        ok();
    }
    
    public static void info(){
        renderTemplate("Extensions/infoarea.html");
        ok();
    }
}
