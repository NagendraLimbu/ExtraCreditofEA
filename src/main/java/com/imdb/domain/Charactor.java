package com.imdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Charactor {

	@Id @GeneratedValue
	private int charactorId;
	
}
