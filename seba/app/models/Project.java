package models;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

/*
 * Model for a project
 * @author: Andreas Wagner
 */
@Entity
public class Project extends Model{

	public String	title;
	public String	teaser;
	@Lob
	public String	description;
	@ManyToOne
	public Company	owner;
	
	public Project(String title, String teaser, String description, Company owner) {
		super();
		this.title = title;
		this.teaser = teaser;
		this.description = description;
		this.owner = owner;
	}
}
