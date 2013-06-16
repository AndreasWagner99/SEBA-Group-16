package models;

import javax.persistence.Entity;
import play.data.validation.*;

/*
 * Model class for the Designer
 * @Author: Andreas Wagner
 * @Author: Anamika Chowdhury
 */

@Entity
public class Designer extends User {

	@Required(message = "Please Enter FirstName") public String firstName;
	@Required(message = "Please Enter LastName") public String lastName;
	//Maybe later it will be a dedicated type instead of a int 
	//public int		rating;
	
	public Designer(String firstName, String lastName, String street, String zip, String city, String password, String verifyPassword, String email) {
		super(street, zip, city, password, verifyPassword, email, true);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String toString()  {
        return firstName +" "+ lastName;
    }
	
}