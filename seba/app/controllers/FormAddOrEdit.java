package controllers;

import models.Company;
import models.Designer;
import models.User;
import play.mvc.Controller;

/**
 * Add or Edit Information for Company or User
 * @author Anamika
 *
 */
public class FormAddOrEdit extends BasicAuthenticationController {
	
	public static void designerinfo(Designer designer)
	{
		//Designer d = Designer.find("byEmail", designer.email).first();
		Designer d = (Designer) Designer.findAll().get(0);
		render(d);
		
	}
	public static void companyinfo(Company company)
	{
		Company c = Company.find("byEmail", company.email).first();
		render(c);
		
	}
	
	public static void editdesignerinfo(Designer designer)
	{
		Designer d = Designer.find("byEmail", designer.email).first();
		//Designer d = (Designer) Designer.findAll().get(0);
			/*validation.valid(designer);
			if(validation.hasErrors()) {
            //validation.keep();
            render("@FormAddOrEdit.designerinfo", designer, true);
			}	*/
			d.email = designer.email;
			d.firstName = designer.firstName;
			d.lastName = designer.lastName;
			d.city = designer.city;
			d.street = designer.street;
			d.zip = designer.zip;
			d.isDesigner = true;
			d.password = designer.password;
			d.verifyPassword = designer.password;
			d.save();
			render("@Application.index");
		
	}
	
	public static void editcompanyinfo(Company company, boolean isEdit)
	{
		Company c = Company.find("byEmail", company.email).first();		
			/*validation.valid(company);
			if(validation.hasErrors()) {
            //validation.keep();
            render("@FormAddOrEdit.companyinfo", company, true);
			}	*/
			c.email = company.email;
			c.companyName = company.companyName;
			c.city = company.city;
			c.street = company.street;
			c.zip = company.zip;
			c.isDesigner = false;
			c.password = company.password;
			c.verifyPassword = company.password;
			c.save();
			render("@Application.index");
	}

}
