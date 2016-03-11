package com.gatesgtbit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Servlet implementation class EventDetails
 */
@WebServlet({"/EventDetails","/eventdetails"})
public class EventDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String ename,banimg;
		String utime;
		String emnames,emno,emids;
		String desc;
		String sname;
		String ecnames1,ecnames2,ecno1,ecno2,ecids1,ecids2;
		try 
		{	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			dbFactory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new URL("http://gatesapi.herokuapp.com/xml/events.xml").openStream());			
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("ROW");
			try
			{	JSONArray array=new JSONArray();
				for (int temp = 0; temp < nList.getLength()/2; temp++) 
				{	Node nNode = nList.item(temp);			
					if (nNode.getNodeType() == Node.ELEMENT_NODE) 
					{	Element eElement = (Element) nNode;
						JSONObject enme=new JSONObject();
						JSONObject banner=new JSONObject();
						JSONObject untime=new JSONObject();
						ename=eElement.getElementsByTagName("ENAME").item(0).getTextContent();
						enme.put("ename",ename);
						
						banimg=eElement.getElementsByTagName("EBANNER").item(0).getTextContent();
						banner.put("banner",banimg);
						
						utime=eElement.getElementsByTagName("ETIME").item(0).getTextContent();
						untime.put("utime",utime);
						
						NodeList emlist = doc.getElementsByTagName("EM");
						JSONArray em=new JSONArray();
						for(int j=0;j<emlist.getLength();j++)
						{	Node emNode = emlist.item(j);	
							if (emNode.getNodeType() == Node.ELEMENT_NODE) 
							{	Element emElement = (Element) emNode;
								JSONObject emname=new JSONObject();
								JSONObject emid=new JSONObject();
								JSONObject emph=new JSONObject();
								emnames=emElement.getElementsByTagName("NAME").item(0).getTextContent();
								emname.put("emname",emnames);
								
								emno=emElement.getElementsByTagName("EMAIL").item(0).getTextContent();
								emid.put("emmail",emno);
								
								emids=emElement.getElementsByTagName("PHONE").item(0).getTextContent();
								emph.put("emphno",emids);
								
								em.put(emname);
								em.put(emid);
								em.put(emph);
							}	
						}
						JSONArray ec=new JSONArray();
						JSONObject ed=new JSONObject();
						desc=eElement.getElementsByTagName("ED").item(0).getTextContent();
						ed.put("desc",desc);
						NodeList eclist1 = doc.getElementsByTagName("EC1");
						for(int j=0;j<eclist1.getLength();j++)
						{	Node ecNode = eclist1.item(j);	
							if (ecNode.getNodeType() == Node.ELEMENT_NODE) 
							{	Element ecElement = (Element) ecNode;
								JSONObject ecname=new JSONObject();
								JSONObject ecid=new JSONObject();
								JSONObject ecph=new JSONObject();
								ecnames1=ecElement.getElementsByTagName("NAME").item(0).getTextContent();
								ecname.put("ecname",ecnames1);
								
								ecids1=ecElement.getElementsByTagName("EMAIL").item(0).getTextContent();
								ecid.put("ecemail",ecids1);
								
								ecno1=ecElement.getElementsByTagName("PHONE").item(0).getTextContent();
								ecph.put("ecphone",ecno1);
								
								ec.put(ecname);
								ec.put(ecid);
								ec.put(ecph);
								
							}	
						}
						array.put(ec);
						ec=new JSONArray();
						NodeList eclist2 = doc.getElementsByTagName("EC2");
						for(int j=0;j<eclist2.getLength();j++)
						{	Node ecNode = eclist2.item(j);	
							if (ecNode.getNodeType() == Node.ELEMENT_NODE) 
							{	Element ecElement = (Element) ecNode;
								JSONObject ecname=new JSONObject();
								JSONObject ecid=new JSONObject();
								JSONObject ecph=new JSONObject();
								ecnames2=ecElement.getElementsByTagName("NAME").item(0).getTextContent();
								ecname.put("ecname",ecnames2);
								
								ecids2=ecElement.getElementsByTagName("EMAIL").item(0).getTextContent();
								ecid.put("ecname",ecids2);
								
								ecno2=ecElement.getElementsByTagName("PHONE").item(0).getTextContent();
								ecph.put("ecphone",ecno2);
								
								ec.put(ecname);
								ec.put(ecid);
								ec.put(ecph);
							}	
						}
						array.put(ec);
						sname=eElement.getElementsByTagName("SNAME").item(0).getTextContent();
						JSONObject snm=new JSONObject();
						snm.put("sname",sname);
						array.put(enme);
						array.put(banner);
						array.put(untime);	
						array.put(em);		
						array.put(ed);
						array.put(snm);
					}
				}
				out.println(array.toString());
			}
			catch(Exception e)
			{	e.printStackTrace();
			}
		} 
		catch (Exception e) 
		{	e.printStackTrace();
		}
	}

}
