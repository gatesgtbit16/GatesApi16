package com.gatesgtbit.controller;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.gatesgtbit.model.Event;
import com.gatesgtbit.model.EventCoordinator;
import com.gatesgtbit.model.EventManager;

public class DataHandler extends DefaultHandler 
{	private boolean ename = false;
	private boolean ebanner = false;
	private boolean etime = false;
	private boolean em = false;
	private boolean name = false;
	private boolean email = false;
	private boolean phone = false;
	private boolean ed = false;
	private boolean ec1 = false;
	private boolean ec2 = false;
	private boolean sname = false;
	private EventCoordinator EC1,EC2;
	private EventManager EM;
	private Event event;
	private HashMap<String,Event> eventarr=new HashMap<>();
	private JSONArray events=new JSONArray();
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("ROW")) 
		{	event=new Event();
		} 
		else if (qName.equalsIgnoreCase("ENAME")) 
		{   ename = true;
		} 
		else if (qName.equalsIgnoreCase("EBANNER")) 
		{	ebanner = true;
		} 
		else if (qName.equalsIgnoreCase("ETIME")) 
		{	etime = true;
		}
		else if (qName.equalsIgnoreCase("EM")) 
		{	em = true;
			EM=new EventManager();
		}
		else if (qName.equalsIgnoreCase("NAME")) 
		{	name = true;
		}
		else if (qName.equalsIgnoreCase("EMAIL")) 
		{	email = true;
		}
		else if (qName.equalsIgnoreCase("PHONE")) 
		{	phone = true;
		}
		else if (qName.equalsIgnoreCase("ED")) 
		{	ed = true;
		}
		else if (qName.equalsIgnoreCase("EC1")) 
		{	ec1 = true;
			EC1=new EventCoordinator();
		}
		else if (qName.equalsIgnoreCase("EC2")) 
		{	ec2 = true;
			EC2=new EventCoordinator();
		}
		else if (qName.equalsIgnoreCase("SNAME")) 
		{	sname = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException 
	{   if (qName.equalsIgnoreCase("row")) 
		{   events.put(event.getEventJSONObject().toString());
			eventarr.put(event.getEname(),event);
	    }
		if (qName.equalsIgnoreCase("em")) 
		{   event.setEM(EM);
	    }
		if (qName.equalsIgnoreCase("ec1")) 
		{   event.setEC1(EC1);
	    }
		if (qName.equalsIgnoreCase("ec2")) 
		{   event.setEC2(EC2);
	    }
		if (qName.equalsIgnoreCase("rowset")) 
		{   
	    }
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException 
	{	if (ename) 
		{	ename = false;
			event.setEname(new String(ch, start, length));
	    } 
		else if (ebanner) 
		{   ebanner = false;
			event.setEbanner(new String(ch, start, length));
	    } 
		else if (etime) 
		{   etime = false;
			event.setTime(new String(ch, start, length));
	    }
		else if (name) 
		{   name = false;
			if(em)
			{	EM.setName(new String(ch, start, length));
			}
			if(ec1)
			{	EC1.setName(new String(ch, start, length));
			}
			if(ec2)
			{	EC2.setName(new String(ch, start, length));
			}
	    }
		else if (email) 
		{   email = false;
			if(em)
			{	EM.setEmail(new String(ch, start, length));
			}
			if(ec1)
			{	EC1.setEmail(new String(ch, start, length));
			}
			if(ec2)
			{	EC2.setEmail(new String(ch, start, length));
			}
	    } 
		else if (phone) 
		{   phone = false;
			if(em)
			{	EM.setPhoneno(new String(ch, start, length));
			}
			if(ec1)
			{	EC1.setPhoneno(new String(ch, start, length));
			}
			if(ec2)
			{	EC2.setPhoneno(new String(ch, start, length));
			}
	    }
		else if (ed) 
		{   ed = false;
			event.setDesc(new String(ch, start, length));
	    }
		else if (sname) 
		{   sname = false;
			event.setSname(new String(ch, start, length));
	    }
	}

	public JSONArray getEvents() {
		return events;
	}

	public JSONObject getEvent(String key) {
		return eventarr.get(key).getEventJSONObject();
	}	
}
