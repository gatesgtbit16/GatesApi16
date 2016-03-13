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
 * Servlet implementation class SponsorsInfo
 */
@WebServlet("/SponsorsInfo")
public class SponsorsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SponsorsInfo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{	Class.forName(TableData.DB_DRIVERS);
			Connection con=DriverManager.getConnection(TableData.CONNECTION_URL,TableData.USERNAME,TableData.PASSWORD);
			Statement st=con.createStatement();
			PrintWriter out=response.getWriter();
	        String query1="select * from sponsers";
	    	ResultSet res=st.executeQuery(query1);
	    	JSONArray arr=new JSONArray();
    		while(res.next())
	    	{	JSONObject obj=new JSONObject();
	    		obj.put("name",res.getString(1));
	    		obj.put("banner",res.getString(2));
	    		arr.put(obj);
	    	}
	        con.close();
		}
		catch(Exception e)
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
