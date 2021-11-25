package com.xyz.dal.entity.theater.screen;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "theater_screen_layout")
public class TheaterScreenLayoutEntity {

	@Id
	@GeneratedValue
	@Column(name = "layout_id", unique = true, updatable = false, nullable = false)
	private Long layoutId;

	@ManyToOne
	@JoinColumn(name = "screenId")
	private TheaterScreenEntity theaterScreen;

	@Column(name = "seatClass", updatable = true, nullable = false)
	private String seatClass;

	@Column(name = "rowName", unique = true, updatable = false, nullable = false)
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

	@Override
	public int hashCode() {
		return Objects.hash(layoutId, numSeats, rowName, seatClass, theaterScreen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheaterScreenLayoutEntity other = (TheaterScreenLayoutEntity) obj;
		return Objects.equals(layoutId, other.layoutId) && numSeats == other.numSeats
				&& Objects.equals(rowName, other.rowName) && Objects.equals(seatClass, other.seatClass)
				&& Objects.equals(theaterScreen, other.theaterScreen);
	}

}
