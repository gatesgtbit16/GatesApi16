package com.gatesgtbit.model;

import org.json.JSONObject;

public class EventManager 
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
	
	public JSONObject getEMJSONObject()
	{	JSONObject em=new JSONObject();
		em.put("emname",name);
		em.put("emmail",email);
		em.put("emphno",phoneno);
		return em;
	}
}
