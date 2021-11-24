package com.xyz.dal.entity.show;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "showScheduleId")
	private TheaterShowEntity show;

	@Column(name = "row", updatable = false, nullable = false)
	private String row;

	@Column(name = "seat_num", updatable = false, nullable = false)
	private int seatNum;

	@Column(name = "avail", updatable = false, nullable = false)
	private Boolean available;

	public static ShowSeatAllocationEntity of(TheaterShowEntity showEntity, String row, int seatNum) {
		ShowSeatAllocationEntity entity = new ShowSeatAllocationEntity();
		entity.setShow(showEntity);
		entity.setRow(row);
		entity.setSeatNum(seatNum);
		entity.setAvailable(Boolean.TRUE);
		return entity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getShowSeatAllocationId() {
		return showSeatAllocationId;
	}

	public TheaterShowEntity getShow() {
		return show;
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

	public void setShowSeatAllocationId(Long showSeatAllocationId) {
		this.showSeatAllocationId = showSeatAllocationId;
	}

	public void setShow(TheaterShowEntity show) {
		this.show = show;
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
