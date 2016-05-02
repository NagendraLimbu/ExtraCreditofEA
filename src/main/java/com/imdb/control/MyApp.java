package com.imdb.control;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.imdb.domain.Artist;
import com.imdb.domain.Genre;
import com.imdb.domain.Movie;


public class MyApp {

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("com.imdb.control");
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

			// TODO your code
			List<Artist> act = new ArrayList<Artist>();
			act.add(new Artist("Nagendra", "7", "Hero") );			
			
			Movie movie = new Movie();
			movie.setCategory(Genre.COMMEDY);
			movie.setComment("Good Movie");
			Path p = FileSystems.getDefault().getPath("C:\\Users\\Nagendra\\Desktop\\Hibernet", "1.jpeg");
			byte[] fileData = Files.readAllBytes(p);
			movie.setCover(fileData);
			movie.setName("The God must be crazy");
			movie.setRating("2");
			movie.setActorList(act);
			em.persist(movie);


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
