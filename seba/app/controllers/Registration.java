package controllers;
import models.Company;
import models.Designer;
import models.Project;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Registration extends Controller {
	
	public static void designer(){
		render();
	}
	public static void company(){
		render();
	}
	public static void saveDesigner(@Valid Designer designer)
	{ 
		validation.valid(designer);
        if(validation.hasErrors()) {
            //validation.keep();
        	render("@Registration.designer", designer);
        }  
        designer.create();
        session.put("user", designer.toString());
        renderTemplate("@Application.index",designer.toString());
		
	}
	public static void saveCompany(@Valid Company company)
	{
		validation.valid(company);
		if(validation.hasErrors()) {
            //validation.keep();
            render("@Registration.company", company);
        }
        company.create();
        session.put("company", company.email);
        renderTemplate("@Application.index",company.companyName);
		
	}
}