package com.xyz.dal.entity.show;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.xyz.dal.entity.theater.TheaterScreenEntity;

@Entity
@Table(name = "screen_seat_layout")
public class ScreenSeatLayoutEntity {

	@Id
	@GeneratedValue
	@Column(name = "layout_id", unique = true, updatable = false, nullable = false)
	private Long layoutId;
	
	@ManyToOne
	@JoinColumn(name = "screenId")
	private TheaterScreenEntity theaterScreen;
	
	@Column(name = "rowName", unique = true, updatable = false, nullable = false)
	private String rowName;
	
	@Column(name = "num_seats", updatable = false, nullable = false)
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
}
