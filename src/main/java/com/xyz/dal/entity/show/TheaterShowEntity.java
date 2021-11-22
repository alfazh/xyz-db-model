package com.xyz.dal.entity.show;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.xyz.dal.entity.movie.MovieEntity;
import com.xyz.dal.entity.theater.TheaterEntity;

@Entity
@Table(name = "theater_show")
public class TheaterShowEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8249430834653676293L;

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "theaterId")
	private TheaterEntity theater;

	@ManyToOne
	@JoinColumn(name = "movieId")
	private MovieEntity movie;

	public Long getId() {
		return id;
	}

	public TheaterEntity getTheater() {
		return theater;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTheater(TheaterEntity theater) {
		this.theater = theater;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

}
