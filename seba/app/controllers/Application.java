package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    @Before(priority=10)
    static void setConnectedUser()
    {
        if(Security.isConnected()) {
            User user =  (User)User.findAll().get(0);
            renderArgs.put("user", user);
        }
    }
    
    public static void index() {
        render();
    }
    public static void login() {
        render();
    }
    public static void logout() {
        session.clear();
        index();
    }
    public static void check(String email, String password) {
        validation.required(email);
        validation.required(password);
        
        if(validation.hasErrors()) {
            params.flash(); // add http parameters to the flash scope
            validation.keep(); // keep the errors for the next request
            Application.login();
        }
        User user = User.connection(email, password);
        if(user != null) {
            session.put("user", user.email);
            if(user.isDesigner==true){
            	
            }
            renderTemplate("@Application.index",user.email);
        }
        play.data.validation.Error error = validation.required(user).error;
        if(error != null) {
            params.flash(); // add http parameters to the flash scope
            validation.keep(); // keep the errors for the next request
            Application.login();
        }     
    }
}