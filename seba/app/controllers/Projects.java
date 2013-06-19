package controllers;

import java.io.File;
import java.util.List;

import models.Project;
import play.mvc.Controller;
import play.mvc.With;

public class Projects extends BasicAuthenticationController {

	public static void list(){
		List<Project> projects = Project.findAll();
		render(projects);
	}
	
    public static void newProject(){
    	
      //  new Project(title, teaser, description, mycompany).save();
      //  ok();
    }
}
