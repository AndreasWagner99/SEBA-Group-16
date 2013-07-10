import static org.junit.Assert.*;
import models.Company;
import models.Designer;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;


public class DesignerTest extends UnitTest{

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
      //Tests if creating new Designer works as expected 
        Designer designer = new Designer("john", "doe", "street", "zip", "city", "password", "password", "mail@mail.de");
        
        designer.save();
        
        Designer d2 = (Designer) Designer.find("byFirstNameAndLastName", "john", "doe").fetch().get(0);
        
        // Test 
        assertEquals(designer.id, d2.id);
    }

}
