package com.imdb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Director extends Person{
	
	//private String directorName;
	
	@ManyToMany(mappedBy="director",cascade=CascadeType.PERSIST)
	private List<Movie> movie = new ArrayList<Movie>();
	
	public Director(String name){
		super(name);	}


	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

}
