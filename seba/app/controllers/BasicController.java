package controllers;

import models.Company;
import models.Designer;
import models.User;
import play.mvc.Before;
import play.mvc.Controller;

public class BasicController extends Controller {

    @Before
    static void setConnectedUser()
    {
        if(Security.isConnected()) {
            User user =  (User)User.find("byEmail", Security.connected()).first();
            if(user != null){
                if(user.isDesigner){
                    renderArgs.put("designer", ((Designer)(Designer.findById(user.id))).firstName);
                }
                else{
                    Company c = Company.findById(user.id);
                    renderArgs.put("company", c);
                }
            }
        }
    }
    
}
