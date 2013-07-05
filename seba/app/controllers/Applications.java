package controllers;

import java.io.File;
import java.util.ArrayList;
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
    
    //List Applications
    public static void list(Long projectId){
        Project p = Project.findById(projectId);
        List<Appl> applications = Appl.find("byProjectAndIsActive", p, true).fetch();
        render(applications);
    }
    
    //List projects as a sidebar (radiobuttons)
    public static void review(Long companyID){
        Company c = Company.findById(companyID);
        List<Project> projects = Project.find("byOwner", c).fetch();
        render(projects);
    }
    
    //Dismiss an application
    public static void dismiss(){
        Long applicationID = Long.valueOf(params.get("applicationid"));
        Appl a = Appl.findById(applicationID);
        a.isActive = false;
        a.save();
        ok();
    }
    
    //Accept an application
    public static void accept(){
        Long applicationID = Long.valueOf(params.get("applicationid"));
        Appl a = Appl.findById(applicationID);
        Project p = Project.findById(a.project.id);
        List<Appl> otherApplications = Appl.find("byProject", p).fetch();
        //Accepting one application implicits dismissing of all others
        for(Appl appl : otherApplications){
            if(appl.id != a.id){
                appl.isActive = false;
                appl.save();
            }
        }
        //Application is now accepted
        a.isAccepted = true;
        a.save();
        //Project will be hided from browsable content
        p.isVisible = false;
        p.save();
        //returns the saved Application which is now the only valid one
        response.status = 200;
        List<Appl> applications = new ArrayList<Appl>();
        applications.add(a);
        render("Applications/list.html",applications);
    }
}
