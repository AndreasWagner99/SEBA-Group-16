package controllers;

import java.io.File;
import java.util.List;

import models.Company;
import models.Project;
import play.mvc.Controller;
import play.mvc.With;

public class Projects extends BasicAuthenticationController {

	public static void list(){
		List<Project> projects = Project.findAll();
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
}
