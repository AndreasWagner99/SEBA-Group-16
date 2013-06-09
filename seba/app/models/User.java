package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

/*
 * Base-Entity for a User
 * used to act as the super-class for all roles in the project
 * @Author: Andreas Wagner
 */
@Entity
public class User extends Model{

	public String	street;
	public int		zip;
	public String	city;
	public String	userName;
	public String	password;
	
	public User(String street, int zip, String city) {
		super();
		this.street = street;
		this.zip = zip;
		this.city = city;
	}
}
