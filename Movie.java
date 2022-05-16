package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {

	@Id
	private String movieId;

	@Column
	private String movieName;
	@Column
	private String language;
	@Column
	private int releasedIn;
	@Column
	private int revenueInDollar;

	public String getmovieId() {
		return movieId;

	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getReleasedIn() {
		return releasedIn;
	}

	public void setReleasedIn(int releasedIn) {
		this.releasedIn = releasedIn;
	}

	public int getRevenueInDollar() {
		return revenueInDollar;
	}

	@Override
	public String toString() {

		return this.movieId + " " + this.movieName + " " + this.language + " " + this.releasedIn + " "
				+ this.revenueInDollar;
	}

	public void setRevenueInDollar(int revenueInDollar) {
		this.revenueInDollar = revenueInDollar;
	}

	public Movie() {
		super();

	}

}