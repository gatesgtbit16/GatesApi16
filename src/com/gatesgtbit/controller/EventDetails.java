package com.gatesgtbit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.gatesgtbit.model.Event;
import com.gatesgtbit.model.EventCoordinator;
import com.gatesgtbit.model.EventManager;
import com.gatesgtbit.model.TableData;

/**
 * Servlet implementation class EventDetail
 */
@WebServlet({ "/EventDetails", "/EventDocs" })
public class EventDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventDetails() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	String query=request.getParameter("q");
		try 
		{	Class.forName(TableData.DB_DRIVERS);
			Connection con=DriverManager.getConnection(TableData.CONNECTION_URL,TableData.USERNAME,TableData.PASSWORD);
			Statement st=con.createStatement();
			PrintWriter out=response.getWriter();
	        if(query.equals("all"))
	        {   String query1="select * from event_details";
	        	ResultSet res=st.executeQuery(query1);
	        	JSONArray events=new JSONArray();
	        	while(res.next())
	        	{	Event event=new Event();
	        		event.setEname(res.getString(1));
	        		event.setEbanner(res.getString(2));
	        		event.setTime1(res.getString(3));
	        		EventManager EM=new EventManager();
	        		EM.setName(res.getString(4));
	        		EM.setPhoneno(res.getString(7));
	        		EM.setEmail(res.getString(8));
	        		event.setEM(EM);
	        		EventCoordinator EC1=new EventCoordinator();
	        		EventCoordinator EC2=new EventCoordinator();
	        		EC1.setName(res.getString(5));
	        		EC2.setName(res.getString(6));
	        		event.setEC1(EC1);
	        		event.setEC2(EC2);
	        		event.setDesc(res.getString(9));
	        		event.setTime2(res.getString(10));
	        		event.setTime3(res.getString(11));
	        		event.setVenue(res.getString(12));
	        		event.setEventid(res.getInt(13));
	        		event.setSname(res.getString(14));
	        		events.put(event.getEventJSONObject());
	        	}
	        	out.println(events.toString());
	        }
	        else
	        {	String query1="select * from event_details where event_id="+query;
	        	ResultSet res=st.executeQuery(query1);
	        	JSONArray events=new JSONArray();
	        	while(res.next())
	        	{	Event event=new Event();
	        		event.setEname(res.getString(1));
	        		event.setEbanner(res.getString(2));
	        		event.setTime1(res.getString(3));
	        		EventManager EM=new EventManager();
	        		EM.setName(res.getString(4));
	        		EM.setPhoneno(res.getString(7));
	        		EM.setEmail(res.getString(8));
	        		event.setEM(EM);
	        		EventCoordinator EC1=new EventCoordinator();
	        		EventCoordinator EC2=new EventCoordinator();
	        		EC1.setName(res.getString(5));
	        		EC2.setName(res.getString(6));
	        		event.setEC1(EC1);
	        		event.setEC2(EC2);
	        		event.setDesc(res.getString(9));
	        		event.setTime2(res.getString(10));
	        		event.setTime3(res.getString(11));
	        		event.setVenue(res.getString(12));
	        		event.setEventid(res.getInt(13));
	        		event.setSname(res.getString(14));
	        		events.put(event.getEventJSONObject());
	        	}
	        	out.println(events.toString());	
	        }
	        con.close();
		} 
		catch (Exception e) 
		{	e.printStackTrace();
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
