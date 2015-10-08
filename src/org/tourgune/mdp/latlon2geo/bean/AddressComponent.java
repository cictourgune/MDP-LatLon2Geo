package org.tourgune.mdp.latlon2geo.bean;
import java.util.List;

public class AddressComponent {
	
	List<Address> address=null;

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AddressComponent [address=" + address + "]";
	}
	
	

}
