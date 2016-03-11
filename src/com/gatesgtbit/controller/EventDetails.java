package com.gatesgtbit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	String query=request.getParameter("q");
		try 
		{   SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser saxParser = factory.newSAXParser();
	        DataHandler userhandler = new DataHandler();
	        saxParser.parse(new URL("http://gatesapi.herokuapp.com/xml/events.xml").openStream(), userhandler);     
	        String API=userhandler.getEvents().toString();
	        PrintWriter out=response.getWriter();
	        if(query.equals("all"))
	        {   out.println(API);
	        }
	        else
	        {	out.println(userhandler.getEvent(query));
	        }
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
