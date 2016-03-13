package com.gatesgtbit.sandbox;

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
 * Servlet implementation class SocietySandbox
 */
@WebServlet("/SocietySandbox")
public class SocietySandbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocietySandbox() {
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
		String sname=request.getParameter("sname");
		String sbanner=request.getParameter("sbanner");
		String sinfo=request.getParameter("sinfo");
		try
		{	Class.forName(TableData.DB_DRIVERS);
			Connection con=DriverManager.getConnection(TableData.CONNECTION_URL,TableData.USERNAME,TableData.PASSWORD);
			Statement st=con.createStatement();
			String Q="insert into societies values('"+sname+"','"+sbanner+"','"+sinfo+"')";
			if(!sname.equals("")&&!sinfo.equals(""))
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
