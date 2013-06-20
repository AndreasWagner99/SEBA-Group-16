package controllers;

import models.Company;
import models.Designer;
import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class BasicAuthenticationController extends BasicController {

    
}
