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
@Table(name = "theater_shows", uniqueConstraints = { @UniqueConstraint(columnNames = { "theaterid", "movieid" }) })
public class TheaterShowEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8249430834653676293L;

	@Id
	@GeneratedValue
	@Column(name = "theater_show_id", unique = true, updatable = false, nullable = false)
	private Long theaterShowId;

	@ManyToOne
	@JoinColumn(name = "theaterId")
	private TheaterEntity theater;

	@ManyToOne
	@JoinColumn(name = "movieId")
	private MovieEntity movie;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "show", cascade = CascadeType.ALL)
	private List<ShowScheduleEntity> showSchedule;

	public Long getTheaterShowId() {
		return theaterShowId;
	}

	public TheaterEntity getTheater() {
		return theater;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public List<ShowScheduleEntity> getShowSchedule() {
		return showSchedule;
	}

	public void setTheaterShowId(Long theaterShowId) {
		this.theaterShowId = theaterShowId;
	}

	public void setTheater(TheaterEntity theater) {
		this.theater = theater;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public void setShowSchedule(List<ShowScheduleEntity> showSchedule) {
		this.showSchedule = showSchedule;
	}

}
