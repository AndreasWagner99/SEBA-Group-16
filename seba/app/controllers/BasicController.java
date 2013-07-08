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
                    Designer d = (Designer)(Designer.findById(user.id));
                    renderArgs.put("designer", d);
                    renderArgs.put("isPremium", d.isPremium);
                }
                else{
                    Company c = Company.findById(user.id);
                    renderArgs.put("company", c);
                }
            }
        }
    }
    
}
