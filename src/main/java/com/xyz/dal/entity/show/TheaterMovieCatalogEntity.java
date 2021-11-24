package com.xyz.dal.entity.show;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.xyz.dal.entity.movie.MovieEntity;
import com.xyz.dal.entity.theater.TheaterEntity;

@Entity
@Table(name = "theater_movie_catalog", uniqueConstraints = { @UniqueConstraint(columnNames = { "theaterid", "movieid" }) })
public class TheaterMovieCatalogEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8249430834653676293L;

	@Id
	@GeneratedValue
	@Column(name = "theater_movie_catalog_id", unique = true, updatable = false, nullable = false)
	private Long theaterMovieCatalogId;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "theaterId")
	private TheaterEntity theater;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "movieId")
	private MovieEntity movie;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "showSchedule", cascade = CascadeType.ALL)
	private List<TheaterShowEntity> showSchedule;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getTheaterMovieCatalogId() {
		return theaterMovieCatalogId;
	}

	public TheaterEntity getTheater() {
		return theater;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public List<TheaterShowEntity> getShowSchedule() {
		return showSchedule;
	}

	public void setTheaterMovieCatalogId(Long theaterMovieCatalogId) {
		this.theaterMovieCatalogId = theaterMovieCatalogId;
	}

	public void setTheater(TheaterEntity theater) {
		this.theater = theater;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public void setShowSchedule(List<TheaterShowEntity> showSchedule) {
		this.showSchedule = showSchedule;
	}

}
