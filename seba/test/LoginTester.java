import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import models.Designer;
import models.User;
import play.mvc.Http.Request;
import play.mvc.Http.Response;
import play.test.FunctionalTest;


public class LoginTester extends FunctionalTest{
    
    @Test
    public void testLogin(){
        new Designer("Test", "User", "teststreet", "testzip", "testcity", 
                "secret", "secret", "user@test.com").save();
        Map<String, String> loginParams = new HashMap<String, String>();
        loginParams.put("username", "user@test.com");
        loginParams.put("password", "secret");
        
        Response response = POST("/login", loginParams);
        
        //Test if we are redirected
        assertStatus(302, response);
        
        //Test e.g. project listing, can only be done by designer
        Request request = newRequest();
        request.cookies = response.cookies; // this makes the request authenticated
        request.url = "/projects/list";
        request.method = "GET";
        Response r = makeRequest(request);
        assertIsOk(r); // Passes!
    }
    
    @Test
    public void testFalseLogin(){
        Map<String, String> loginParams = new HashMap<String, String>();
        loginParams.put("username", "user@example.com");
        loginParams.put("password", "nosecret");
        Response response = POST("/login", loginParams);
        
        assertStatus(302, response);
        
        //Test e.g. project listing
        Request request = newRequest();
        request.cookies = response.cookies; // this makes the request authenticated
        request.url = "/projects/list";
        request.method = "GET";
        Response r = makeRequest(request);
        //We should be redirected again!
        assertStatus(302, response);
    }
    
    @Test
    public void logout(){
        Response response = GET("/logout");
       // assertIsOk(response);
    }
}
