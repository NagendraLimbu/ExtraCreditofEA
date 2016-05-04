package com.imdb.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="ARTIST_CHARACTER")
public class ArtistCharacter {

	@Id @GeneratedValue
	private int charactorId;	
	private String artistRole;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="artist")
	private Artist artist;
	
	public ArtistCharacter(String role){
		
		this.artistRole=role;
	}
	
	public int getCharactorId() {
		return charactorId;
	}
	public void setCharactorId(int charactorId) {
		this.charactorId = charactorId;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getArtistRole() {
		return artistRole;
	}

	public void setArtistRole(String artistRole) {
		this.artistRole = artistRole;
	}
	
}
