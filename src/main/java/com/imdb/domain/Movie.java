package com.imdb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;


@Entity
public class Movie {

	@Id
	@GeneratedValue
	private int movieId;

	@Enumerated(EnumType.STRING)
	private Genre category;

	private String name;
	private String comment;
	@Lob
	private byte[] cover;
	private String rating;

	@ManyToMany
	@JoinTable(name="Movie_Person",
			joinColumns={ @JoinColumn(name="movieId")},
			inverseJoinColumns={ @JoinColumn(name="personId")}
			)
	private List<Artist> person = new ArrayList<Artist>();

	public List<Artist> getActorList() {
		return person;
	}

	public void setActorList(List<Artist> actorList) {
		this.person = actorList;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int id) {
		movieId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
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

}
