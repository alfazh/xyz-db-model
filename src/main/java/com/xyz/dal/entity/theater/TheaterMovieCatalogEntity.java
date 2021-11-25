package com.xyz.dal.entity.theater;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.xyz.dal.entity.movie.MovieEntity;

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

//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "showSchedule", cascade = CascadeType.ALL)
//	private List<ShowEntity> showSchedule;

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

//	public List<ShowEntity> getShowSchedule() {
//		return showSchedule;
//	}

	public void setTheaterMovieCatalogId(Long theaterMovieCatalogId) {
		this.theaterMovieCatalogId = theaterMovieCatalogId;
	}

	public void setTheater(TheaterEntity theater) {
		this.theater = theater;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movie, theater, theaterMovieCatalogId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheaterMovieCatalogEntity other = (TheaterMovieCatalogEntity) obj;
		return Objects.equals(movie, other.movie) && Objects.equals(theater, other.theater)
				&& Objects.equals(theaterMovieCatalogId, other.theaterMovieCatalogId);
	}

//	public void setShowSchedule(List<ShowEntity> showSchedule) {
//		this.showSchedule = showSchedule;
//	}

}
