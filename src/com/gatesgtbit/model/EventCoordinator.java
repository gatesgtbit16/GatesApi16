package com.gatesgtbit.model;

import org.json.JSONObject;

public class EventCoordinator
{	private String name,phoneno,email;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneno() {
		return phoneno;
	}
	
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public JSONObject getECJSONObject()
	{	JSONObject ec=new JSONObject();
		ec.put("ecname",name);
		ec.put("ecemail",email);
		ec.put("ecphone",phoneno);
		return ec;
	}
}
