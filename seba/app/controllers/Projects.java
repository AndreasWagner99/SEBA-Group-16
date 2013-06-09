package controllers;

import java.util.List;

import models.Project;
import play.mvc.Controller;



public class Projects extends Controller {

	public static void list(){
		List<Project> projects = Project.findAll();
		render(projects);
	}
}
