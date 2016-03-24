package com.gatesgtbit.model;

import org.json.JSONObject;

public class EventListData 
{	private String name,desc,sname;
	private String time,banner,category;
	private int eid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public JSONObject getJSONObject()
	{	JSONObject js=new JSONObject();
		js.put("eid",eid);
		js.put("ename",name);
		js.put("ebanner", banner);
		js.put("time",time);
		js.put("desc",desc);
		js.put("sname", sname);
		js.put("category", category);
		return js;
	}
}
