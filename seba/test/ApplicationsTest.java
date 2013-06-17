import models.Appl;
import models.Designer;
import models.Project;

import org.junit.Test;

import play.test.UnitTest;


public class ApplicationsTest extends UnitTest {

    @Test
    public void newApplicationTest(){
        Designer designer = Designer.findById(0L);
        Project project = Project.findById(0L);
        String explanation = "Testapplication";
        Appl s = new Appl(designer, project, explanation);
        Appl save = s.save();
        assertEquals(s, save);
    }
}
