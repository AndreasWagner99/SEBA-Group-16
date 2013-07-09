package models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	public boolean  isVisible;
	public boolean  isEdited;
	
	public Project(String title, String teaser, String description, Company owner) {
		super();
		this.title = title;
		this.teaser = teaser;
		this.description = description;
		this.owner = owner;
		this.isVisible = true;
		this.isEdited = false;
	}
}
