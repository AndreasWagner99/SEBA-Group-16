package controllers;

import models.Company;
import models.Designer;
import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

public class AjaxHelper extends Controller {
    
    @Before
    static void setConnectedUser()
    {
        if(Security.isConnected()) {
            User user =  (User)User.find("byEmail", Security.connected()).first();
            if(user.isDesigner){
                renderArgs.put("designer", ((Designer)(Designer.findById(user.id))).firstName);
            }
            else{
                renderArgs.put("company", ((Company)Company.findById(user.id)).companyName);
            }
        }
    }
    
    public static void menu(){
        renderTemplate("Navigation/menu.html");
        ok();
    }
}
