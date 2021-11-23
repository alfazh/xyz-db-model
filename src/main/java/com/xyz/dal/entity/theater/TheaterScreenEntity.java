package com.xyz.dal.entity.theater;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "theater_screen")
public class TheaterScreenEntity {

	@Id
	@GeneratedValue
	@Column(name = "screenId", unique = true, updatable = false, nullable = false)
	private Integer screenId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "theaterId", nullable = false)
	private TheaterEntity theater;

	@Column(name = "name", updatable = true, nullable = false)
	private String name;

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

}