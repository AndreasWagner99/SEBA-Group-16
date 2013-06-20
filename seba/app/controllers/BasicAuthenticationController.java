package controllers;

import models.Company;
import models.Designer;
import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class BasicAuthenticationController extends Controller {

    @Before
    static void setConnectedUser()
    {
        if(Security.isConnected()) {
            User user =  (User)User.find("byEmail", Security.connected()).first();
            if(user.isDesigner){
                renderArgs.put("designer", ((Designer)user).firstName);
            }
            else{
                renderArgs.put("company", ((Company)user).companyName);
            }
        }
    }
}
