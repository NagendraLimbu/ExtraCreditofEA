package com.imdb.domain;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Artist extends Person {

	//@Temporal(TemporalType.DATE)
	private String dateOfBirth;
	private String birthPlace;	
	private String biography;
//	@Lob
//	private byte[] photo;

	@ManyToMany(mappedBy="artist")
	private List<Movie> movie = new ArrayList<Movie>();
	
	@OneToMany(mappedBy="artist", cascade=CascadeType.PERSIST)
	private List<ArtistCharacter> characterList=new ArrayList<ArtistCharacter>();
		
	public Artist(String name,String dob, String birthplace, String biography,List<ArtistCharacter> characterlist){
		super(name);
		this.dateOfBirth=dob;
		this.birthPlace=birthplace;
		this.biography=biography;
		this.characterList=characterlist;		
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

/*	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}*/

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	public List<ArtistCharacter> getCharacterList() {
		return characterList;
	}

	public void setCharacterList(List<ArtistCharacter> characterList) {
		this.characterList = characterList;
	}

	
}
