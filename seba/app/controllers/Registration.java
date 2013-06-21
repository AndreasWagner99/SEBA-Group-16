package controllers;
import models.Company;
import models.Designer;
import models.Project;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

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
        designer.save();
        session.put("designer", designer);
        renderTemplate("@Application.index");
		
	}
	public static void saveCompany(@Valid Company company)
	{
		validation.valid(company);
		if(validation.hasErrors()) {
            //validation.keep();
            render("@Registration.company", company);
        }
        company.save();
        session.put("company", company);
        renderTemplate("@Application.index");
		
	}
}
