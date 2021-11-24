package com.xyz.dal.entity.show;

import java.io.Serializable;
import java.time.LocalDate;
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

import com.xyz.dal.entity.theater.TheaterScreenEntity;

@Entity
@Table(name = "show_schedule", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "screenid", "date", "show_time", "theatershowid" }) })

public class ShowScheduleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7097903902322342138L;

	@Id
	@GeneratedValue
	@Column(name = "show_schedule_id", unique = true, updatable = false, nullable = false)
	private Long showScheduleId;

	@ManyToOne
	@JoinColumn(name = "theaterShowId")
	private TheaterShowEntity show;

	@Column(name = "date", updatable = false, nullable = false)
	private LocalDate date;

	@Column(name = "show_time", updatable = false, nullable = false)
	private LocalTime time;

	@ManyToOne
	@JoinColumn(name = "screenId")
	private TheaterScreenEntity screen;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "showSchedule", cascade = CascadeType.ALL)
	private List<ShowPricingEntity> showPricing;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "showSchedule", cascade = CascadeType.ALL)
	private Set<ShowSeatAllocationEntity> showSeatAllocation;
	
	public Long getShowScheduleId() {
		return showScheduleId;
	}

	public void setShowScheduleId(Long showScheduleId) {
		this.showScheduleId = showScheduleId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public TheaterScreenEntity getScreen() {
		return screen;
	}

	public void setScreen(TheaterScreenEntity screen) {
		this.screen = screen;
	}

	public TheaterShowEntity getShow() {
		return show;
	}

	public void setShow(TheaterShowEntity show) {
		this.show = show;
	}

	public List<ShowPricingEntity> getShowPricing() {
		return showPricing;
	}

	public Set<ShowSeatAllocationEntity> getShowSeatAllocation() {
		return showSeatAllocation;
	}

	public void setShowPricing(List<ShowPricingEntity> showPricing) {
		this.showPricing = showPricing;
	}

	public void setShowSeatAllocation(Set<ShowSeatAllocationEntity> showSeatAllocation) {
		this.showSeatAllocation = showSeatAllocation;
	}

}
