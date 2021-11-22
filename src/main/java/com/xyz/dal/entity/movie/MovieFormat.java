package com.xyz.dal.entity.movie;

public enum MovieFormat {

	TWO_D("2D"), THREE_D("3D"), IMAX_FOUR_D("IMAX 4D");

	String formatString;

	private MovieFormat(String formatString) {
		this.formatString = formatString;
	}

	public String getFormatString() {
		return formatString;
	}

	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}

}
