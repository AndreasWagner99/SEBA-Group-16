package controllers;

import models.Appl;
import models.Designer;
import models.Project;
import play.mvc.Controller;
import play.mvc.results.Ok;
import play.mvc.results.Result;

public class Applications extends Controller{

    public static void newApplication(long projId, String description){
        Project p = Project.findById(projId);
        Designer d = (Designer) Designer.findAll().get(0);
        Appl app = new Appl(d, p, description);
        app.save();
        ok();
    }
}
