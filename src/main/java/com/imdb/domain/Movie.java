package com.imdb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private int movieId;

	private String title;
	private String comment;
	private String year;
	private String rating;
	@Enumerated(EnumType.STRING)
	private Genre category;
 
	@ManyToMany
	@JoinTable(name="Movie_Artist",
			joinColumns={ @JoinColumn(name="movieId")},
			inverseJoinColumns={ @JoinColumn(name="artistId")}
			)
	private List<Artist> artist=new ArrayList();
	
	@ManyToMany
	@JoinTable(name="Movie_Director",
			joinColumns={ @JoinColumn(name="movieId")},
			inverseJoinColumns={ @JoinColumn(name="directorId")}
			)
	private List<Director> director=new ArrayList();
	
	@ManyToMany
	@JoinTable(name="Movie_User",
			joinColumns={ @JoinColumn(name="movieId")},
			inverseJoinColumns={ @JoinColumn(name="userId")}
			)
	private List<User> user=new ArrayList();

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	
}