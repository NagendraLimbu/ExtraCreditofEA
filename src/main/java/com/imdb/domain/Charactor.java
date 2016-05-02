package com.imdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Charactor {

	@Id @GeneratedValue
	private int charactorId;
	@ManyToMany(mappedBy="charactor")
	private Artist artist;
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
	
}
