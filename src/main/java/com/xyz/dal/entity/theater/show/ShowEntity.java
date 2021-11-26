package com.xyz.dal.entity.theater.show;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

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

import com.xyz.dal.entity.theater.screen.TheaterScreenEntity;

@Entity
@Table(name = "theater_show", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "showscheduleid", "screenid", "show_time", }) })

public class ShowEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7097903902322342138L;

	@Id
	@GeneratedValue
	@Column(name = "show_id", unique = true, updatable = false, nullable = false)
	private Long showId;

	@ManyToOne
	@JoinColumn(name = "showScheduleId")
	private ShowScheduleEntity showSchedule;

	@Column(name = "show_time", updatable = false, nullable = false)
	private LocalTime time;

	@ManyToOne
	@JoinColumn(name = "screenId")
	private TheaterScreenEntity screen;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "show", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ShowPricingEntity> showPricing;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "show", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ShowSeatAllocationEntity> showSeatAllocation;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getShowId() {
		return showId;
	}

	public ShowScheduleEntity getShowSchedule() {
		return showSchedule;
	}

	public LocalTime getTime() {
		return time;
	}

	public TheaterScreenEntity getScreen() {
		return screen;
	}

	public List<ShowPricingEntity> getShowPricing() {
		return showPricing;
	}

	public Set<ShowSeatAllocationEntity> getShowSeatAllocation() {
		return showSeatAllocation;
	}

	public void setShowId(Long showId) {
		this.showId = showId;
	}

	public void setShowSchedule(ShowScheduleEntity showSchedule) {
		this.showSchedule = showSchedule;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public void setScreen(TheaterScreenEntity screen) {
		this.screen = screen;
	}

	public void setShowPricing(List<ShowPricingEntity> showPricing) {
		this.showPricing = showPricing;
	}

	public void setShowSeatAllocation(Set<ShowSeatAllocationEntity> showSeatAllocation) {
		this.showSeatAllocation = showSeatAllocation;
	}

}
