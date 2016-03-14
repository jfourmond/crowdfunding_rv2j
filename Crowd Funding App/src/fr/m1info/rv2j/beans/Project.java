package fr.m1info.rv2j.beans;

import java.sql.Date;
import java.util.List;

/**
 * Représentation d'un Projet
 */
public class Project {
	private int id;
	private String name;
	private String presentation;
	private int author_id;
	private List<Integer> contributors;
	private List<Compensation> compensations;
	private List<Commentary> commentaries;
	private Date creation_date;
	private Date last_update_date;
	
	/*	GETTERS	*/
	public int getID() { return id; }
	
	public String getName() { return name; }

	public String getPresentation() { return presentation; }

	public int getAuthor_id() { return author_id; }

	public List<Integer> getContributors() { return contributors; }

	public List<Compensation> getCompensations() { return compensations; }

	public List<Commentary> getCommentaries() { return commentaries; }

	public Date getCreationDate() { return creation_date; }
	
	public Date getLastUpdateDate() { return last_update_date; }

	/*	SETTERS	*/
	public void setID(int id) { this.id = id; }
	
	public void setName(String name) { this.name = name; }
	
	public void setPresentation(String presentation) { this.presentation = presentation; }

	public void setAuthor_id(int id) { this.author_id = id; }
	
	public void setContributors(List<Integer> contributors) { this.contributors = contributors; }
	
	public void setCompensations(List<Compensation> compensations) { this.compensations = compensations; }

	public void setCommentaries(List<Commentary> commentaries) { this.commentaries = commentaries; }
	
	public void setCreationDate(Date date) { this.creation_date = date; }

	public void setLastUpdateDate(Date date) { this.last_update_date = date; }
}
