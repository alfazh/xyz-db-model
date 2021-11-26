package com.xyz.dal.entity.theater.screen;

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

import com.xyz.dal.entity.theater.TheaterEntity;

@Entity
@Table(name = "theater_screen", uniqueConstraints = { @UniqueConstraint(columnNames = { "theaterid", "screen_id" })})
public class TheaterScreenEntity {

	@Id
	@GeneratedValue
	@Column(name = "screen_id", unique = true, updatable = false, nullable = false)
	private Integer screenId;

	@ManyToOne
	@JoinColumn(name = "theaterId", nullable = false)
	private TheaterEntity theater;

	@Column(name = "name", updatable = true, nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "theaterScreen", cascade = CascadeType.ALL)
	private List<ScreenSeatRowEntity> seatRowList;

	public Integer getScreenId() {
		return screenId;
	}

	public TheaterEntity getTheater() {
		return theater;
	}

	public String getName() {
		return name;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}

	public void setTheater(TheaterEntity theater) {
		this.theater = theater;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ScreenSeatRowEntity> getSeatRowList() {
		return seatRowList;
	}

	public void setSeatRowList(List<ScreenSeatRowEntity> seatRowList) {
		this.seatRowList = seatRowList;
	}

}
