package com.gatesgtbit.model;

import org.json.JSONObject;

public class EventCoordinator
{	private String name;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public JSONObject getECJSONObject()
	{	JSONObject ec=new JSONObject();
		ec.put("ecname",name);
		return ec;
	}
}
