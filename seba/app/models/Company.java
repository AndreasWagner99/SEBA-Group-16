package models;

import javax.persistence.Entity;

import play.data.validation.Required;

/*
 * Model for the company user
 * @Author: Andreas Wagner
 * @Author: Anamika Chowdhury
 */
@Entity
public class Company extends User {

	@Required(message = "Please Enter Company Name") 
	public String	companyName;
	public Company(String companyName, String street, String zip, String city,String password, String verifyPassword, String email) {
		super(street, zip, city, password, verifyPassword, email, false);
		this.companyName = companyName;
	}
}