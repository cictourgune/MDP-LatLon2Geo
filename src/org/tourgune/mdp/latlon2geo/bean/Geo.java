package org.tourgune.mdp.latlon2geo.bean;

public class Geo {

	private String postal_code = null;
	private String street_number = null;
	private String route = null;
	private String locality = null;
	private String administrative_area_level_4 = null;
	private String administrative_area_level_3 = null;
	private String administrative_area_level_2 = null;
	private String administrative_area_level_1 = null;
	private String country = null;
	
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getStreet_number() {
		return street_number;
	}
	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getAdministrative_area_level_4() {
		return administrative_area_level_4;
	}
	public void setAdministrative_area_level_4(String administrative_area_level_4) {
		this.administrative_area_level_4 = administrative_area_level_4;
	}
	public String getAdministrative_area_level_3() {
		return administrative_area_level_3;
	}
	public void setAdministrative_area_level_3(String administrative_area_level_3) {
		this.administrative_area_level_3 = administrative_area_level_3;
	}
	public String getAdministrative_area_level_2() {
		return administrative_area_level_2;
	}
	public void setAdministrative_area_level_2(String administrative_area_level_2) {
		this.administrative_area_level_2 = administrative_area_level_2;
	}
	public String getAdministrative_area_level_1() {
		return administrative_area_level_1;
	}
	public void setAdministrative_area_level_1(String administrative_area_level_1) {
		this.administrative_area_level_1 = administrative_area_level_1;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Geo [country=" + country + ", "
				+ "administrative_area_level_1=" + administrative_area_level_1 + ", "
				+ "administrative_area_level_2=" + administrative_area_level_2 + ", "
				+ "administrative_area_level_3=" + administrative_area_level_3 + ", "
				+ "administrative_area_level_4=" + administrative_area_level_4 + ", "
				+ "locality=" + locality + ", "
				+ "route=" + route + ", "
				+ "street_number=" + street_number + ", "
				+ "postal_code=" + postal_code
				+ "]";
	}
	
		
}
