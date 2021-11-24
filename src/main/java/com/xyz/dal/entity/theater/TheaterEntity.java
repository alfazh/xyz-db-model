package com.xyz.dal.entity.theater;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="theater")
public class TheaterEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1018065187366052735L;

	@Id
	@GeneratedValue
	@Column(name = "theater_id", unique = true, updatable = false, nullable = false)
	private Long theaterId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "type", nullable = false)
	private TheaterType type;

	@Column(name = "city", nullable = false)
	private String city;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "theater", cascade = CascadeType.ALL)
	private List<TheaterScreenEntity> screens;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public TheaterType getType() {
		return type;
	}

	public void setType(TheaterType type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getTheaterId() {
		return theaterId;
	}

	public List<TheaterScreenEntity> getScreens() {
		return screens;
	}

	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}

	public void setScreens(List<TheaterScreenEntity> screens) {
		this.screens = screens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, city, theaterId, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheaterEntity other = (TheaterEntity) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(theaterId, other.theaterId) && Objects.equals(name, other.name) && type == other.type;
	}

}
