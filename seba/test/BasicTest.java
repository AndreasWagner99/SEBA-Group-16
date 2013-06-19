import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void newProject(){
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
