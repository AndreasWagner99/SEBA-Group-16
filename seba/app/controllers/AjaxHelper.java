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
}
