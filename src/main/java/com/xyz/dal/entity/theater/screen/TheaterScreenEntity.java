package com.xyz.dal.entity.theater.screen;

import java.util.List;
import java.util.Objects;

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

import com.xyz.dal.entity.theater.TheaterEntity;

@Entity
@Table(name = "theater_screen")
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
	private List<TheaterScreenLayoutEntity> seatLayoutList;
	
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

	public List<TheaterScreenLayoutEntity> getSeatLayoutList() {
		return seatLayoutList;
	}

	public void setSeatLayoutList(List<TheaterScreenLayoutEntity> seatLayoutList) {
		this.seatLayoutList = seatLayoutList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, screenId, seatLayoutList, theater);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheaterScreenEntity other = (TheaterScreenEntity) obj;
		return Objects.equals(name, other.name) && Objects.equals(screenId, other.screenId)
				&& Objects.equals(seatLayoutList, other.seatLayoutList) && Objects.equals(theater, other.theater);
	}

}
