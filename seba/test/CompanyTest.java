import static org.junit.Assert.*;
import models.Appl;
import models.Company;
import models.Designer;
import models.Project;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;


public class CompanyTest extends UnitTest{

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void newCompany() {
      //Tests if creating new Company works as expected 
        Company mycompany = new Company("testcompany",
                "teststreet",
                "9999",
                "city",
                "password",
                "password",
                "mail@mail.de");
        
        mycompany.save();
        
        Company c2 = (Company) Company.find("byCompanyname", "testcompany").fetch().get(0);
        
        // Test 
        assertEquals(mycompany.id, c2.id);
    }

}
