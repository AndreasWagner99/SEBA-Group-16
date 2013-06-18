package controllers;

import java.util.List;

import models.Project;
import play.mvc.Controller;
import play.mvc.With;

public class Projects extends BasicAuthenticationController {

	public static void list(){
		List<Project> projects = Project.findAll();
		render(projects);
	}
}
