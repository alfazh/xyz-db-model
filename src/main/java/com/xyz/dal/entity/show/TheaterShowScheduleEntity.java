package com.xyz.dal.entity.show;

import java.time.LocalDate;
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

@Entity
@Table(name = "theater_show_schedule", uniqueConstraints = { @UniqueConstraint(columnNames = { "date", "theatermoviecatalogid" }) })
public class TheaterShowScheduleEntity {

	@Id
	@GeneratedValue
	@Column(name = "show_schedule_id", unique = true, updatable = false, nullable = false)
	private Long showScheduleId; 
	
	@Column(name = "date", updatable = false, nullable = false)
	private LocalDate date;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "theaterMovieCatalogId")
	private TheaterMovieCatalogEntity theaterCatalog;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "showSchedule", cascade = CascadeType.ALL)
	private List<TheaterShowEntity> showList;
	
	public Long getShowScheduleId() {
		return showScheduleId;
	}

	public LocalDate getDate() {
		return date;
	}

	public TheaterMovieCatalogEntity getTheaterCatalog() {
		return theaterCatalog;
	}

	public void setShowScheduleId(Long showScheduleId) {
		this.showScheduleId = showScheduleId;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setTheaterCatalog(TheaterMovieCatalogEntity theaterCatalog) {
		this.theaterCatalog = theaterCatalog;
	}

	public List<TheaterShowEntity> getShowList() {
		return showList;
	}

	public void setShowList(List<TheaterShowEntity> showList) {
		this.showList = showList;
	}
	
	
}
