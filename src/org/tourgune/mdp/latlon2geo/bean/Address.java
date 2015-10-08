package org.tourgune.mdp.latlon2geo.bean;

import java.util.List;

public class Address {
	
	String short_name=null;
	String long_name=null;
	List<String> types=null;
	
	
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public String getLong_name() {
		return long_name;
	}
	public void setLong_name(String long_name) {
		this.long_name = long_name;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	@Override
	public String toString() {
		return "Address [short_name=" + short_name + ", long_name=" + long_name
				+ ", types=" + types + "]";
	}
	
	
	
	
	

}
