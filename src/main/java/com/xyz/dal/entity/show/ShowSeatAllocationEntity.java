package com.xyz.dal.entity.show;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "show_seat_allocation")
public class ShowSeatAllocationEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 69265202094892795L;

	@Id
	@GeneratedValue
	@Column(name = "show_seat_alloc_id", unique = true, updatable = false, nullable = false)
	private Long showSeatAllocationId;

	@ManyToOne
	@JoinColumn(name = "showScheduleId")
	private ShowScheduleEntity showScheduleEntity;

	@Column(name = "row", updatable = false, nullable = false)
	private String row;

	@Column(name = "seat_num", updatable = false, nullable = false)
	private int seatNum;

	@Column(name = "avail", updatable = false, nullable = false)
	private Boolean available;

	public Long getShowSeatAllocationId() {
		return showSeatAllocationId;
	}

	public void setShowSeatAllocationId(Long showSeatAllocationId) {
		this.showSeatAllocationId = showSeatAllocationId;
	}

	public ShowScheduleEntity getShowScheduleEntity() {
		return showScheduleEntity;
	}

	public String getRow() {
		return row;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setShowScheduleEntity(ShowScheduleEntity showScheduleEntity) {
		this.showScheduleEntity = showScheduleEntity;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}
