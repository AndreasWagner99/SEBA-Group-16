package models;

import javax.persistence.Entity;

/*
 * Model class for the Designer
 * @Author: Andreas Wagner
 */

@Entity
public class Designer extends User {

	public String	firstName;
	public String	lastName;
	//Maybe later it will be a dedicated type instead of a int 
	public int		rating;
	
	public Designer(String firstName, String lastName, String street, int zip, String city) {
		super(street, zip, city);
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
