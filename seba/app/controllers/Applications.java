package controllers;

import java.io.File;

import models.Appl;
import models.Designer;
import models.Project;
import play.mvc.Controller;
import play.mvc.results.Ok;
import play.mvc.results.Result;

public class Applications extends Controller{

    public static void newApplication(){
        String projId = params.get("projId");
        File f = params.get("file", File.class);
        Project p = Project.findById(Long.valueOf(projId));
        Designer d = (Designer) Designer.findAll().get(0);
        Appl app = new Appl(d, p, params.get("description"));
        app.save();
        ok();
    }
}
