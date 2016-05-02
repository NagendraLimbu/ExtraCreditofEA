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

	private String title;
	private String comment;
	private String year;
	private String rating;
	@Enumerated(EnumType.STRING)
	private Genre category;

	@ManyToMany
	@JoinTable(name="Movie_Person",
			joinColumns={ @JoinColumn(name="movieId")},
			inverseJoinColumns={ @JoinColumn(name="personId")}
			)
	private List<Artist> person = new ArrayList<Artist>();
	