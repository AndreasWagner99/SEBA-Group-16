package models;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Blob;
import play.db.jpa.Model;

/*
 * Model for an Application
 * @Author: Andreas Wagner
 */
@Entity
public class Appl extends Model {

	@ManyToOne
	public Designer	designer;
	@ManyToOne
	public Project	project;
	public String	explanation;
	public boolean  isActive;
	public boolean  isAccepted;
	public Blob     proposal;
	
	public Appl(Designer designer, Project project, String explanation, Blob prop) {
		super();
		this.designer = designer;
		this.project = project;
		this.explanation = explanation;
		this.isActive = true;
		this.isAccepted = false;
		this.proposal = prop;
	}
}
