package com.gatesgtbit.model;

import org.json.JSONObject;

public class Event implements Comparable<Event>
{	private String ename,ebanner,sname;
	private String time,desc;

	private EventManager EM;
	private EventCoordinator EC1,EC2;
	
	public Event() {
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public JSONObject getEventJSONObject()
	{	JSONObject event=new JSONObject();
		event.put("ename",ename);
		event.put("banner",ebanner);
		event.put("utime",time);
		event.put("desc",desc);
		event.put("sname",sname);
		JSONObject em=EM.getEMJSONObject();
		JSONObject ec1=EC1.getECJSONObject();
		JSONObject ec2=EC2.getECJSONObject();	
		event.put("emanager",em);
		event.put("ecoor1",ec1);
		event.put("ecoor2",ec2);
		return event;
	}
	
	@Override
	public int compareTo(Event E) {
		if(E.getTime()==time)
		{	return 0;
		}
		else if(Long.parseLong(E.getTime())>Long.parseLong(time))
		{	return 1;
		}
		else
		{	return -1;
		}
	}
}
