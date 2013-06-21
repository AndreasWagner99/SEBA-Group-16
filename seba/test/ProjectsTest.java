import models.Company;
import models.Project;

import org.junit.Test;

import play.test.UnitTest;


public class ProjectsTest extends UnitTest{

    @Test
    public void testNewProject(){
        Company mycompany = Company.findById(0L);
        // Create a new project and save it
        new Project("Kenny's Project", "This is the teaser for my project", "Tis is a longer description for my Project", mycompany).save();
        
        // Retrieve the Project with title
        Project KennyP = Project.find("title", "Kenny's Project").first();
        
        // Test 
        assertNotNull(KennyP);
        assertEquals("This is the teaser for my project", KennyP.teaser);
    }
}
