package controllers;

import java.io.File;

import models.Appl;
import models.Designer;
import models.Project;
import play.mvc.Controller;
import play.mvc.With;
import play.mvc.results.Ok;
import play.mvc.results.Result;

@With(Secure.class)
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
}
