package com.xyz.dal.entity.movie;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class MovieEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7997668794067115204L;

	@Id
	@GeneratedValue
	@Column(name = "movie_id", unique = true, updatable = false, nullable = false)
	private Long movieId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "genre", nullable = false)
	private Genre genre;

	@Column(name = "image_link", nullable = true)
	private String imageLink;

	@Enumerated(EnumType.STRING)
	@Column(name = "language", nullable = false)
	private Language language;

	@Column(name = "run_time", nullable = false)
	private int runTime;

	@Column(name = "release_date", nullable = true)
	private LocalDate releaseDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "movie_format", nullable = false)
	private MovieFormat movieformat;

	public Long getMovieId() {
		return movieId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Genre getGenre() {
		return genre;
	}

	public String getImageLink() {
		return imageLink;
	}

	public Language getLanguage() {
		return language;
	}

	public int getRunTime() {
		return runTime;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public MovieFormat getMovieformat() {
		return movieformat;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setMovieformat(MovieFormat movieformat) {
		this.movieformat = movieformat;
	}

	@Override
	public String toString() {
		return "MovieEntity [id=" + movieId + ", name=" + name + ", genre=" + genre + "]";
	}

}
