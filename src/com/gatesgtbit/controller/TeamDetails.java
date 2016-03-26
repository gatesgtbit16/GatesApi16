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

import com.gatesgtbit.model.TableData;
import com.gatesgtbit.model.Team;

/**
 * Servlet implementation class TeamDetails
 */
@WebServlet("/TeamDetails")
public class TeamDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamDetails() {
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
	        String query1="select name,desig,image from team_details order by sorder asc";
        	ResultSet res=st.executeQuery(query1);
        	JSONArray event=new JSONArray();
        	while(res.next())
        	{	Team team=new Team();
        		team.setName(res.getString(1));
        		team.setDesig(res.getString(2));
        		team.setImage(res.getString(3));
        		event.put(team.getJSONObject());
	        }
        	out.println(event.toString());
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
	}

}
