package com.imdb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Director extends Person{
	
	private String directorName;
	
	@ManyToMany(mappedBy="director")
	private List<Movie> movie = new ArrayList<Movie>();
	
	public Director(String name){
		super(name);	}


	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}


	public String getDirectorName() {
		return directorName;
	}


	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

}
