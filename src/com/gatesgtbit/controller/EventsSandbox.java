package com.gatesgtbit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gatesgtbit.model.TableData;

/**
 * Servlet implementation class EventsSandbox
 */
@WebServlet("/EventsSandbox")
public class EventsSandbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventsSandbox() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String ename=request.getParameter("nevent");
		String ebanner=request.getParameter("banner");
		String ed=request.getParameter("ed");
		String etime1=request.getParameter("time1");
		String etime2=request.getParameter("time2");
		String etime3=request.getParameter("time3");
		String venue=request.getParameter("venue");
		String em=request.getParameter("em");
		String ec1=request.getParameter("ec1");
		String ec2=request.getParameter("ec2");
		String phno=request.getParameter("phno");
		String email=request.getParameter("email");
		String sname=request.getParameter("sname");
		try
		{	Class.forName(TableData.DB_DRIVERS);
			Connection con=DriverManager.getConnection(TableData.CONNECTION_URL,TableData.USERNAME,TableData.PASSWORD);
			Statement st=con.createStatement();
			String Q="insert into event_details (ename,ebanner,etime,emname,ec1name,ec2name,cno,cemail,ed,etime2,etime3,venue,sname)"
					+ "values('"+ename+"','"+ebanner+"','"+etime1+"','"+em+"','"+ec1+"','"+ec2+"','"+phno+"','"+email+"','"+ed+"','"+etime2+"','"+etime3+"','"+venue+"','"+sname+"')";
			if(!ename.equals("")&&!ebanner.equals("")&&!ed.equals("")&&!em.equals("")&&!phno.equals("")&&!email.equals("")&&!venue.equals(""))
			{	int i=st.executeUpdate(Q);
				if(i>0)
				{	out.println("Your Data has been recorded. Thank you for cooperating.");
				}
				else
				{	out.println("There has been some problem submitting your data. Please write us an email.");
				}
			}
			else
			{	out.println("There has been some problem submitting your data.One of the field has been missed.");
			}
			con.close();
		}
		catch(Exception e)
		{	e.printStackTrace();
		}
	}
}
