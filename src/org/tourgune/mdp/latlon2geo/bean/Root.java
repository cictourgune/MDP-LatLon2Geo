package org.tourgune.mdp.latlon2geo.bean;

import java.util.ArrayList;
import java.util.List;


public class Root {
	
	private List<Results> results = null;
	

	private String status = null;
	
	public Root(){
		
		results = new ArrayList<Results>();
		status = "";
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Root [results=" + results + ", status=" + status + "]";
	}

	

}
