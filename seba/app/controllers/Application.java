package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends BasicController {
    
    public static void index() {
        render();
    }
    
public static void premimumPayment(){
    	
    	String cardNum = params.get("cardNum");
    	String cardName = params.get("cardName");
    	String expirydate = params.get("expirydate");
    	String cvv = params.get("cvv");
    	String creditAmt = params.get("creditAmt");
    	Designer d = Designer.findById(Long.valueOf(params.get("designerId")));
    	d.isPremium = true ;
    	new PremiumAccount(d, cardNum, cardName, creditAmt, cvv, expirydate).save();
    	ok();
    }

    public static void terms() {
        render("Pages/terms.html");
    }
    
    public static void privacypolicy() {
        render("Pages/privacypolicy.html");
    }
    
    public static void about() {
        render("Pages/about.html");
    }
    
    public static void howitworks() {
        render("Pages/faqs.html");
    }
    
    @Deprecated
    public static void login() {
        render();
    }
    
    @Deprecated
    public static void logout() {
        session.clear();
        index();
    }
    
    @Deprecated
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