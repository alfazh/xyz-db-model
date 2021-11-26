package com.xyz.dal.entity.movie;

public enum MovieFormat {

	F_2D("2D"), F_3D("3D"), F_IMAX_3D("IMAX 3D");

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
