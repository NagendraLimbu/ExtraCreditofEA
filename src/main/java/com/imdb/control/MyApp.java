package com.imdb.control;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.imdb.domain.Artist;
import com.imdb.domain.ArtistCharacter;
import com.imdb.domain.Comment;
import com.imdb.domain.Director;
import com.imdb.domain.Genre;
import com.imdb.domain.Movie;
import com.imdb.domain.User;


public class MyApp {

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("com.imdb.domain");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static void main(String[] args) {
		addMovies();
		//printMoviesReport();
		emf.close();

	}
	private static void addMovies() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();		
			System.out.println("");
			// Code here			
			
			ArtistCharacter ac1=new ArtistCharacter("Hero");
			ArtistCharacter ac2=new ArtistCharacter("Commedian");
			ArtistCharacter ac3=new ArtistCharacter("Heroin");
			ArtistCharacter ac4=new ArtistCharacter("Villain");
			List<ArtistCharacter> characterlist1=new ArrayList<ArtistCharacter>();
			characterlist1.add(ac1);
			characterlist1.add(ac4);
			List<ArtistCharacter> characterlist2=new ArrayList<ArtistCharacter>();
			characterlist2.add(ac2);
			characterlist2.add(ac3);
			Artist a1=new Artist("Rajesh Hamal","1973-11-12","Nepal", "A great actor. He has played many movies.",characterlist1);
			Artist a2=new Artist("Amitav Bachchan","195-12-22","India", "A great actor. He has played many movies.",characterlist1);
			Artist a3=new Artist("Namrata Shrestha","1975-11-15","Nepal", "A great Actress. She has played many movies.",characterlist2);
		
			List<Artist> artists=new ArrayList<Artist>();
			artists.add(a1);
			artists.add(a2);
			artists.add(a3);
			
			User u1=new User("Nagendra Limbu");
			User u2=new User("Madan Siwakoti");
			Comment c1=new Comment("This movie is nice", u1);
			Comment c2=new Comment("This movie is very nice", u2);
			Comment c3=new Comment("This movie is not so good", u1);
			Comment c4=new Comment("I like this movie", u2);
			
			List<Comment> commentlist=new ArrayList<Comment>();
			commentlist.add(c1);
			commentlist.add(c2);
			commentlist.add(c3);
			commentlist.add(c4);
			
			Director d1=new Director("Dilip Rayamajhi");
			Director d2=new Director("Gobinda Basnet");
			List<Director> directorlist=new ArrayList<Director>();
			directorlist.add(d1);
			directorlist.add(d2);
			Movie m=new Movie("DON", "2016", "5", Genre.ACTION, artists, directorlist, commentlist);
			Movie m1=new Movie("The God Must be Creazy", "2010", "5", Genre.COMMEDY, artists, directorlist, commentlist);
			Movie m2=new Movie("The One", "2008", "5", Genre.ACTION, artists, directorlist, commentlist);
			List<Movie> movielist=new ArrayList<Movie>();
			movielist.add(m);
			movielist.add(m1);
			movielist.add(m2);
			em.persist(m);
			em.persist(m1);
			em.persist(m2);
			//em.persist(movielist);
		
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

}
