package com.gatesgtbit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class SocietesCard
 */
@WebServlet("/SocietesCard")
public class SocietesCard extends HttpServlet 
{	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocietesCard() 
    {   super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	String fname[]={"atu","bli","dlci",
						"edci","elancei","epicturei",
						"etci","gfsi","gi",
						"gsci","ieee","istei",
						"muni","natyai","swaasi",
						"tsgi"};
		String sname[]={"Android Techies","Bhangra Lions","DLC",
						"IIPC","Elance","Epicture",
						"Etcetra","G#","GFS",
						"GSC","IEEE","ISTE",
						"Munistry","Natya","Swaas","TSG"};
		String query=request.getParameter("q");
		if(query.equals("societies"))
		{	JSONArray arr=new JSONArray();
			for(int i=0;i<fname.length;i++)
			{	JSONObject name=new JSONObject();
				name.put("sname",sname[i]);
				name.put("imgurl",fname[i]+".png");
			arr.put(name);
			}
			PrintWriter out=response.getWriter();
			out.println(arr.toString());
		}
	}
}
