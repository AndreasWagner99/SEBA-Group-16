package controllers;

import java.io.File;
import java.util.List;

import models.Appl;
import models.Company;
import models.Designer;
import models.Project;
import play.mvc.Controller;
import play.mvc.With;
import play.mvc.results.Ok;
import play.mvc.results.Result;

public class Applications extends BasicAuthenticationController{

    public static void newApplication(){
        String projId = params.get("projId");
        File f = params.get("file", File.class);
        Project p = Project.findById(Long.valueOf(projId));
        Designer d = (Designer) Designer.findAll().get(0);
        Appl app = new Appl(d, p, params.get("description"));
        app.save();
        ok();
    }
    
    public static void list(Long projectId){
        Project p = Project.findById(projectId);
        List<Appl> applications = Appl.find("byProject", p).fetch();
        render(applications);
    }
    
    public static void review(Long companyID){
        Company c = Company.findById(companyID);
        List<Project> projects = Project.find("byOwner", c).fetch();
        render(projects);
    }
}
