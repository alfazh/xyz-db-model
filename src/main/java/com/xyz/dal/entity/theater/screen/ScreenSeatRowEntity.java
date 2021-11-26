package com.xyz.dal.entity.theater.screen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.xyz.dal.entity.theater.TheaterEntity;

@Entity
@Table(name = "theater_screen_seat_row", uniqueConstraints = { @UniqueConstraint(columnNames = { "theaterid", "screenid","seat_class","row_name" }) })
public class ScreenSeatRowEntity {

	@Id
	@GeneratedValue
	@Column(name = "layout_id", unique = true, updatable = false, nullable = false)
	private Long layoutId;

	@ManyToOne
	@JoinColumn(name = "screenId")
	private TheaterScreenEntity theaterScreen;

	@ManyToOne
	@JoinColumn(name = "theaterId", nullable = false)
	private TheaterEntity theater;
	
	@Column(name = "seat_class", updatable = true, nullable = false)
	private String seatClass;

	@Column(name = "row_name", unique = false, updatable = false, nullable = false)
	private String rowName;

	@Column(name = "num_seats", updatable = true, nullable = false)
	private int numSeats;

	public Long getLayoutId() {
		return layoutId;
	}

	public TheaterScreenEntity getTheaterScreen() {
		return theaterScreen;
	}

	public String getRowName() {
		return rowName;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setLayoutId(Long layoutId) {
		this.layoutId = layoutId;
	}

	public void setTheaterScreen(TheaterScreenEntity theaterScreen) {
		this.theaterScreen = theaterScreen;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public TheaterEntity getTheater() {
		return theater;
	}

	public void setTheater(TheaterEntity theater) {
		this.theater = theater;
	}
	
	
}
