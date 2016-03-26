package com.gatesgtbit.model;

import org.json.JSONObject;

public class Team {
	private String name,desig,image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public JSONObject getJSONObject()
	{	JSONObject person=new JSONObject();
		person.put("name",name);
		person.put("design",desig);
		person.put("image",image);
		return person;
	}
}
