package com.gatesgtbit.model;

public class Event implements Comparable<Event>
{	private String ename,ebanner,sname;
	private long time;
	private EventPerson EM,EC1,EC2;

	
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

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public EventPerson getEM() {
		return EM;
	}

	public void setEM(EventPerson eM) {
		EM = eM;
	}

	public EventPerson getEC1() {
		return EC1;
	}

	public void setEC1(EventPerson eC1) {
		EC1 = eC1;
	}

	public EventPerson getEC2() {
		return EC2;
	}

	public void setEC2(EventPerson eC2) {
		EC2 = eC2;
	}

	@Override
	public int compareTo(Event E) {
		return 0;
	}
}
