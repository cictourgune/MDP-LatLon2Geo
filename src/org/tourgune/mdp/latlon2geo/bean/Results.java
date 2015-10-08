package org.tourgune.mdp.latlon2geo.bean;

import java.util.List;

public class Results {
	
	public List<Address> address_components = null;
	public List<String> types = null;

	public List<Address> getAddress_components() {
		return address_components;
	}

	public void setAddress_components(List<Address> address_components) {
		this.address_components = address_components;
	}

	
	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Results [address_components=" + address_components + "]";
	}

	
}
