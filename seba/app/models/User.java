package models;

import groovy.transform.IndexedProperty;

import javax.persistence.Entity;
import play.data.validation.*;
import play.db.jpa.Model;
/*
 * Base-Entity for a User
 * used to act as the super-class for all roles in the project
 * @Author: Andreas Wagner
 * @Author:Anamika Chowdhury
 */
@Entity
public class User extends Model{

	public String	street;
	@Required @MinSize(5) @Match(value="^[0-9]+$", message="Not a valid Zip Code") public String zip;
	public String	city;
	@Required
    @MaxSize(15)
    @MinSize(5)
	public String password;
	@Required 
	@Equals("password") 
	public String verifyPassword;
	
	@Required 
	@Email
	@CheckWith(MyEmailCheck.class)
	public String email;
	public boolean isDesigner;
	
	public User(String street, String zip, String city, String password, String verifyPassword, String email, boolean isDesigner) {
		super();
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.password=password;
		this.email=email;
		this.verifyPassword=verifyPassword;
		this.isDesigner=isDesigner;
	}
	
	public static User connection(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
		}
	/**
     * Check email is not used by anyone else
     */
    static class MyEmailCheck extends Check {

        public boolean isSatisfied(Object user, Object email) {
            final User found = User.find("byEmail", email).first();
            User given = (User)user;
            setMessage("User Exists Already", (String)email);
            return (given.equals(found))?true:found == null;
        }
    }
	
	
}