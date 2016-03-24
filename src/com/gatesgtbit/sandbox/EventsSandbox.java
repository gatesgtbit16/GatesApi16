package com.gatesgtbit.sandbox;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
		String form=request.getParameter("form1");
		String category=request.getParameter("category");
		try
		{	Class.forName(TableData.DB_DRIVERS);
			Connection con=DriverManager.getConnection(TableData.CONNECTION_URL,TableData.USERNAME,TableData.PASSWORD);
			String Q="insert into event_details (ename,ebanner,etime,emname,ec1name,ec2name,cno,cemail,ed,etime2,etime3,venue,sname,form,category)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			if(!ename.equals("")&&!category.equals("")&&!ebanner.equals("")&&!ed.equals("")&&!em.equals("")&&!phno.equals("")&&!email.equals("")&&!venue.equals(""))
			{	PreparedStatement ps=con.prepareStatement(Q);
				ps.setString(1, ename);
				ps.setString(2, ebanner);
				ps.setString(3, etime1);
				ps.setString(4, em);
				ps.setString(5, ec1);
				ps.setString(6, ec2);
				ps.setString(7, phno);
				ps.setString(8, email);
				ps.setString(9, ed);
				ps.setString(10, etime2);
				ps.setString(11, etime3);
				ps.setString(12, venue);
				ps.setString(13, sname);  
				ps.setString(14, form);  
				ps.setString(15, category);  
				int i=ps.executeUpdate();
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
