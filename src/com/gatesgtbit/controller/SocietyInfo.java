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
import org.json.JSONObject;

import com.gatesgtbit.model.TableData;

/**
 * Servlet implementation class SocietyInfo
 */
@WebServlet({ "/SocietyInfo", "/societyinfo" })
public class SocietyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocietyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q=request.getParameter("sname");
		if(q.equals("all"))
		{	try 
			{	Class.forName(TableData.DB_DRIVERS);
				Connection con=DriverManager.getConnection(TableData.CONNECTION_URL,TableData.USERNAME,TableData.PASSWORD);
				Statement st=con.createStatement();
				PrintWriter out=response.getWriter();
		        String query1="select * from societies";
		    	ResultSet res=st.executeQuery(query1);
		    	while(res.next())
		    	{	JSONArray arr=new JSONArray();
		    		JSONObject obj1=new JSONObject();
		    		JSONObject obj2=new JSONObject();
		    		JSONObject obj3=new JSONObject();
		    		obj1.put("sname",q);
		    		obj2.put("info",res.getString(2));
		    		obj3.put("banner",res.getString(3));
		    		arr.put(obj1);
		    		arr.put(obj2);
		    		arr.put(obj3);
		    		out.print(arr.toString());	
		    	}
		        con.close();
			}
			catch(Exception e)
			{	e.printStackTrace();
			}
		}
		else	
		try 
		{	Class.forName(TableData.DB_DRIVERS);
			Connection con=DriverManager.getConnection(TableData.CONNECTION_URL,TableData.USERNAME,TableData.PASSWORD);
			Statement st=con.createStatement();
			PrintWriter out=response.getWriter();
	        String query1="select * from societies where name='"+q+"' limit 1";
        	ResultSet res=st.executeQuery(query1);
        	while(res.next())
        	{	JSONArray arr=new JSONArray();
        		JSONObject obj1=new JSONObject();
        		JSONObject obj2=new JSONObject();
        		JSONObject obj3=new JSONObject();
        		obj1.put("sname",q);
        		obj2.put("info",res.getString(2));
        		obj3.put("banner",res.getString(3));
        		arr.put(obj1);
        		arr.put(obj2);
        		arr.put(obj3);
        		out.print(arr.toString());	
        	}
	        con.close();
		}
		catch(Exception e)
		{	e.printStackTrace();
		}
	}
}
