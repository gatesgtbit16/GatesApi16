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

import com.gatesgtbit.model.EventListData;
import com.gatesgtbit.model.TableData;

/**
 * Servlet implementation class DayEvents
 */
@WebServlet("/DayEvents")
public class DayEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DayEvents() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String day=request.getParameter("day");
		switch(day)
		{	case "1":	try 
						{	Class.forName(TableData.DB_DRIVERS);
							Connection con=DriverManager.getConnection(TableData.CONNECTION_URL,TableData.USERNAME,TableData.PASSWORD);
							Statement st=con.createStatement();
							PrintWriter out=response.getWriter();
					        String query1="select ename,ebanner,event_id,etime,substring(ed for 50),sname,category from event_details where etime!='' order by etime asc";
				        	ResultSet res=st.executeQuery(query1);
				        	JSONArray event=new JSONArray();
				        	while(res.next())
				        	{	EventListData data=new EventListData();
				        		data.setEid(res.getInt(3));
				        		data.setName(res.getString(1));
				        		data.setBanner(res.getString(2));
				        		data.setTime(res.getString(4));
					    		data.setDesc(res.getString(5)+"...");
					    		data.setSname(res.getString(6));
					    		data.setCategory(res.getString(7));
				        		event.put(data.getJSONObject());
					        }
				        	out.println(event.toString());
				        	con.close();
						}
						catch(Exception e)
						{	e.printStackTrace();				
						}
						break;
						
			case "2":	try 
						{	Class.forName(TableData.DB_DRIVERS);
							Connection con=DriverManager.getConnection(TableData.CONNECTION_URL,TableData.USERNAME,TableData.PASSWORD);
							Statement st=con.createStatement();
							PrintWriter out=response.getWriter();
					        String query1="select ename,ebanner,event_id,etime2,substring(ed for 50),sname,category from event_details where etime2!='' order by etime2 asc";
				        	ResultSet res=st.executeQuery(query1);
				        	JSONArray event=new JSONArray();
				        	while(res.next())
				        	{	EventListData data=new EventListData();
				        		data.setEid(res.getInt(3));
				        		data.setName(res.getString(1));
				        		data.setBanner(res.getString(2));
				        		data.setTime(res.getString(4));
					    		data.setDesc(res.getString(5)+"...");
					    		data.setSname(res.getString(6));
					    		data.setCategory(res.getString(7));
				        		event.put(data.getJSONObject());
					        }
				        	out.println(event.toString());
				        	con.close();
						}
						catch(Exception e)
						{	e.printStackTrace();				
						}
						break;
						
			case "3":	try 
						{	Class.forName(TableData.DB_DRIVERS);
							Connection con=DriverManager.getConnection(TableData.CONNECTION_URL,TableData.USERNAME,TableData.PASSWORD);
							Statement st=con.createStatement();
							PrintWriter out=response.getWriter();
					        String query1="select ename,ebanner,event_id,etime3,substring(ed for 50),sname,category from event_details where etime3!='' order by etime3 asc";
					    	ResultSet res=st.executeQuery(query1);
					    	JSONArray event=new JSONArray();
					    	while(res.next())
					    	{	EventListData data=new EventListData();
					    		data.setEid(res.getInt(3));
					    		data.setName(res.getString(1));
					    		data.setBanner(res.getString(2));
					    		data.setTime(res.getString(4));
					    		data.setDesc(res.getString(5)+"...");
					    		data.setSname(res.getString(6));
					    		data.setCategory(res.getString(7));
					    		event.put(data.getJSONObject());
					        }
					    	out.println(event.toString());
				        	con.close();
						}
						catch(Exception e)
						{	e.printStackTrace();				
						}
						break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
