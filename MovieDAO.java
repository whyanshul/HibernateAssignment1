package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.model.Movie;


public class MovieDAO {

	public MovieDAO() {}
		
	
	public String addMovie(Movie movie) {
        try {
			
        	Configuration cfg = new Configuration().configure("hibernate.cfg.xml"); //Loads hibernate.cfg.xml

			ServiceRegistry reg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(reg).getMetadataBuilder().build();
			SessionFactory factory = metadata.getSessionFactoryBuilder().build();

			Session session = factory.openSession();
			
			session.beginTransaction();
			
			session.persist(movie);
					
					session.getTransaction().commit();

					factory.close();
			session.close();
			
        	
			return "added";
        	
		} catch (Exception e) {
			
			e.printStackTrace();
			return "Error";
		}
	
		
	}

	
	@SuppressWarnings("deprecation")
	public void deleteMovie(String movieId) {
		   try {
				
	        	Configuration cfg = new Configuration().configure("hibernate.cfg.xml"); //Loads hibernate.cfg.xml

				ServiceRegistry reg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				Metadata metadata = new MetadataSources(reg).getMetadataBuilder().build();
				SessionFactory factory = metadata.getSessionFactoryBuilder().build();

				Session session = factory.openSession();
				
				session.beginTransaction();
				Movie m1 = session.load(Movie.class ,movieId);
				session.remove(m1);
			
						
						session.getTransaction().commit();

						factory.close();
				session.close();
		
	        	
			} catch (Exception e) {

				e.printStackTrace();
				
			}
		
		
	}
	@SuppressWarnings("deprecation")
	public void updateMovie(String movieId) {
	try {
		
		
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		ServiceRegistry reg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(reg).getMetadataBuilder().build();
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();

		Session session = factory.openSession();
		
		session.beginTransaction();
		Movie m1 = session.get(Movie.class ,movieId);
		m1.setRevenueInDollar(m1.getRevenueInDollar()+10000);
		session.merge(m1);
	
				
				session.getTransaction().commit();

				factory.close();
		session.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
	public Movie getMoviedetails(String movieId) {
		try {
			
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml"); //Loads hibernate.cfg.xml

			ServiceRegistry reg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(reg).getMetadataBuilder().build();
			SessionFactory factory = metadata.getSessionFactoryBuilder().build();

			Session session = factory.openSession();
			
			session.beginTransaction();
			System.out.println(movieId);
			Movie m1 = session.get(Movie.class ,movieId);
			
		    session.getTransaction().commit();
		    session.close();
		    factory.close();
			
			return m1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
