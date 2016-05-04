package com.imdb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private int movieId;

	private String title;	
	private String year;
	private String rating;
	@Enumerated(EnumType.STRING)
	private Genre category;

	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "Movie_Artist", 
			joinColumns = {@JoinColumn(name= "Movie_ID") }, 
			inverseJoinColumns = { @JoinColumn(name = "Artist_ID") }
			)
	private List<Artist> artist=new ArrayList();
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "Movie_Director", 
			joinColumns = {@JoinColumn(name= "Movie_ID") }, 
			inverseJoinColumns = { @JoinColumn(name = "Director_ID") }
			)
	private List<Director> director=new ArrayList();
	
	@OneToMany(mappedBy="movie", cascade=CascadeType.PERSIST)	
	private List<Comment> comments=new ArrayList();

	public Movie(String title, String year, String rating, Genre g, List<Artist> artistlist, List<Director> directorlist, List<Comment> commentlist){
		this.artist=artistlist;
		this.director=directorlist;
		this.comments=commentlist;
		this.title=title;
		this.year=year;
		this.rating=rating;
		this.category=g;
	}
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Genre getCategory() {
		return category;
	}

	public void setCategory(Genre category) {
		this.category = category;
	}

	public List<Artist> getArtist() {
		return artist;
	}

	public void setArtist(List<Artist> artist) {
		this.artist = artist;
	}

	public List<Director> getDirector() {
		return director;
	}

	public void setDirector(List<Director> director) {
		this.director = director;
	}
	
}