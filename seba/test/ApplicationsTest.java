import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Appl;
import models.Designer;
import models.Project;

import org.junit.Before;
import org.junit.Test;

import controllers.Applications;
import play.mvc.Http.Request;
import play.mvc.Http.Response;
import play.test.Fixtures;
import play.test.FunctionalTest;
import play.test.UnitTest;


public class ApplicationsTest extends FunctionalTest {
    
    @Before
    public void setup(){
        Fixtures.deleteDatabase();
        Fixtures.loadModels("basedata.yml");
    }
    
    @Test
    public void testNewApplication(){
        //Tests if creating new applications works as expected 
        Designer designer = Designer.findById(1L);
        Project project = Project.findById(1L);
        String explanation = "Testapplication";
        //We don't need an image in the test
        Appl s = new Appl(designer, project, explanation, null);
        Appl save = s.save();
        assertEquals(s, save);
    }
    
    @Test
    public void testAppliationAccept(){
        //Tests if accepting application works as expected
        //Login first
        Map<String, String> loginUserParams = new HashMap<String, String>();
        loginUserParams.put("username", "user@ibm.com");
        loginUserParams.put("password", "secret");
        Response loginResponse = POST("/login", loginUserParams);
        
        //Create test data
        Designer designer = (Designer) Designer.findAll().get(0);
        Project project1 = (Project) Project.findAll().get(0);
        String proposal = "Test";
        
        //Create Application
        Appl s = new Appl(designer, project1, proposal, null);
        s.save();
        s = new Appl(designer, project1, proposal, null);
        Appl save = s.save();
        
        //Prepare Post
        Request request = newRequest();
        request.cookies = loginResponse.cookies; // this makes the request authenticated
        request.url = "/applications/accept";
        request.method = "POST";
        request.params.put("applicationid", save.id.toString());
        
        //Call Controller Method
        Response r = POST(request, "/applications/accept");
        assertStatus(200, r);
        
        //Check if one of all apps is accepted
        List<Appl> applications = Appl.find("byProject", project1).fetch();
        int accept_counter = 0;
        for(Appl a : applications){
            if(a.isAccepted)
                accept_counter++;
        }
        assertEquals(1, accept_counter);
    }
    
    @Test
    public void testAppliationDismiss(){
        //Tests if accepting application works as expected
        //Login first
        Map<String, String> loginUserParams = new HashMap<String, String>();
        loginUserParams.put("username", "user@ibm.com");
        loginUserParams.put("password", "secret");
        Response loginResponse = POST("/login", loginUserParams);
        
        //Create test data
        Designer designer = (Designer) Designer.findAll().get(0);
        Project project1 = (Project) Project.findAll().get(0);
        String proposal = "Test";
        
        //Create Application
        Appl s = new Appl(designer, project1, proposal, null);
        Appl save = s.save();
        
        //Prepare Post
        Request request = newRequest();
        request.cookies = loginResponse.cookies; // this makes the request authenticated
        request.url = "/applications/dismiss";
        request.method = "POST";
        request.params.put("applicationid", save.id.toString());
        
        //Call Controller Method
        Response r = POST(request, "/applications/accept");
        assertStatus(200, r);
        Appl savenew = Appl.findById(save.id);
        //Check if application is dismissed
        assertEquals(false, savenew.isActive);
    }
}
