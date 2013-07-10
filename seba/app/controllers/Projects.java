package controllers;

import java.io.File;
import java.util.List;

import models.Company;
import models.Project;
import play.mvc.Controller;
import play.mvc.With;

public class Projects extends BasicAuthenticationController {

	public static void list(){
		List<Project> projects = Project.find("isVisible", true).fetch();
		render(projects);
	}
	
    public static void newProject(){
        String title = params.get("title");
        String teaser = params.get("teaser");
        String description = params.get("description");
        Company c = Company.findById(Long.valueOf(params.get("companyId")));
        new Project(title, teaser, description, c).save();
        ok();
    }
    
    public static void myprojects(Long companyId){
        Company c = Company.findById(companyId);
    	List<Project> projects = Project.find("byOwner", c).fetch();	
		render(projects);	
	}
    
    public static void edit(String projectTitle){
		Project p = Project.find("byTitle", projectTitle).first();
		render(p);
		
	}
    
    public static void finishediting(Project p)
	{
		Project Newp = Project.find("byID", p.id).first();		
		Newp.title = p.title;
		Newp.teaser = p.teaser;
		Newp.description = p.description;
		Newp.isVisible = true;
		Newp.isEdited = true;
		
		Newp.save();
		
		redirect("/myprojects?companyId="+Newp.owner.id);
	}
}
