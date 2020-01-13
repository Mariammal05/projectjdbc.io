package com.cognizant.movie.model;

import java.util.Date;

public class Movies {
	private Long id;
	private String title;
	private String genre;
	private long gross;
	private Boolean active;
	private Date dateOfLaunch;
	private Boolean hasTeaser;

	public Movies(Long id, String title, long gross, Boolean active, Date dateOfLaunch, String genre,
			Boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.gross = gross;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.hasTeaser = hasTeaser;
	}

	public Movies() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Long getGross() {
		return gross;
	}

	public void setGross(long gross) {
		this.gross = gross;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public Boolean getHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(Boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	
}
