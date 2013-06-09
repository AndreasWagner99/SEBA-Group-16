package models;

import javax.persistence.Entity;

/*
 * Model for the company user
 * @Author: Andreas Wagner
 */
@Entity
public class Company extends User {

	public String	companyName;
	
	public Company(String companyName, String street, int zip, String city) {
		super(street, zip, city);
		this.companyName = companyName;
	}
}
