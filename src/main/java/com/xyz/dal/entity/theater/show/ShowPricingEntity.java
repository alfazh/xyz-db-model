package com.xyz.dal.entity.theater.show;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "theater_show_pricing")
public class ShowPricingEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1969145322598557977L;

	@Id
	@GeneratedValue
	@Column(name = "show_pricing_id", unique = true, updatable = false, nullable = false)
	private Long showPricingId;

	@ManyToOne
	@JoinColumn(name = "showId")
	private ShowEntity show;

	@Column(name = "seat_class", updatable = false, nullable = false)
	private String seatClass;

	@Column(name = "price", updatable = false, nullable = false)
	private BigDecimal price;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getShowPricingId() {
		return showPricingId;
	}

	public ShowEntity getShow() {
		return show;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setShowPricingId(Long showPricingId) {
		this.showPricingId = showPricingId;
	}

	public void setShow(ShowEntity show) {
		this.show = show;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
