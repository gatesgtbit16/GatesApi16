package com.gatesgtbit.model;

import org.json.JSONObject;

public class Event
{	private int eventid;
	private String ename,ebanner,sname;
	private String time1,time2,time3,desc;
	private String venue,form;
	private EventManager EM;
	private EventCoordinator EC1,EC2;
	
	public Event() {
	}
	
	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc=desc;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEbanner() {
		return ebanner;
	}

	public void setEbanner(String ebanner) {
		this.ebanner = ebanner;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getTime3() {
		return time3;
	}

	public void setTime3(String time3) {
		this.time3 = time3;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public EventManager getEM() {
		return EM;
	}

	public void setEM(EventManager EM) {
		this.EM=EM;
	}
	
	
	public EventCoordinator getEC1() {
		return EC1;
	}

	public void setEC1(EventCoordinator EC1) {
		this.EC1 = EC1;
	}

	public EventCoordinator getEC2() {
		return EC2;
	}

	public void setEC2(EventCoordinator EC2) {
		this.EC2 = EC2;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public JSONObject getEventJSONObject()
	{	JSONObject event=new JSONObject();
		event.put("eid",eventid);
		event.put("ename",ename);
		event.put("banner",ebanner);
		event.put("time1",time1);
		event.put("time2",time2);
		event.put("time3",time3);
		event.put("venue",venue);
		event.put("desc",desc);
		event.put("sname",sname);
		JSONObject em=EM.getEMJSONObject();
		JSONObject ec1=EC1.getECJSONObject();
		JSONObject ec2=EC2.getECJSONObject();	
		event.put("emanager",em);
		event.put("ecoor1",ec1);
		event.put("ecoor2",ec2);
		event.put("form",form);
		return event;
	}
}
