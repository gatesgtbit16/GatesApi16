package com.gatesgtbit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

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
		// TODO Auto-generated method stub
		String q=request.getParameter("sname");
		String info="",banner="";
		ServletContext servletContext = getServletContext();
		String contextPath = servletContext.getContextPath();
		switch(q)
		{	case "Android Techies":	info="The need of knowing ‘Android’, being engineering students, was felt and recognised "
										+"by the core members of the society, sprouting the idea of building a society to support "
										+"this thought. The idea was welcomed by the authorities of the college and was marked as "
										+"an influential field. Under the constant support of the Director General of the college, "
										+"Sardar Gurmeet Singh Soin, coupled with the adequate guidance of Mr. Gaurav Sandhu, the "
										+"current teacher coordinator of Android Techies, has led to the rise of the society in "
										+"enormous proportions. The success of getting a cent per cent enrolment of students of "
										+"GTBIT with Android has been immense. Android Techies aims to bring out the technical side "
										+"of the students and makes them think big. Today, the society is providing Android guidance "
										+"and training to the college students as a 24/7 service. The society which started with "
										+"eight students, has now managed to gather more than sixty students in a very short span of "
										+"time. Though, the society has released some of these apps on play store there are many more "
										+"awaited, to be released soon.";
	
									banner=contextPath+"/img/banners/androidtechies.png";
									break;
		
			case "Bhangra Lions":	info="The Bhangra Society of GTBIT, known as the GTBIT Bhangra Lions, are a group of passionate "
										+"individuals with collective interests of jitterbug and prance, all drawn together by our "
										+"love of Bhangra. Bhangra is a traditional dance form originating from Punjab that today, "
										+"with its bass-infused beats and high energy movements, has spread worldwide. The vision of "
										+"the Bhangra Lions is to embrace the spirit of celebration, generosity and community that is "
										+"Bhangra. It is dedicated in spreading the universal rhythm of Bhangra and welcoming people "
										+"from all cultures to enjoy the beats of this beautiful art form. Besides the skillful ability "
										+"to develop beats that make the listener want to get up and dance, what sets Bhangra Lions apart "
										+"is their knack to set the stage colorful. Dressed in traditional Punjab wear, moving swiftly and "
										+"rhythmically on the tunes of Punjabi folk, these students are a sight to see. Transformed and "
										+"reintroduced as the Bhangra Lions in the year 2010.";
			
									banner=contextPath+"/img/banners/bhangra.jpg";
									break;
									
			case "DLC":					info="In the month of February in 2004, two students from the 2002-06 batch and four from the 2003-07 "
										+"batch formulated the institute’s first recognized society – D’ Lang Chaps. Once the name was "
										+"finalized, they announced their first GD for 4th year students in association with a major MBA "
										+"training school in Delhi. It took a few successful events (including a mock CAT for 3rd and 4th "
										+"year students, that saw participation of over a 100 partakers for the first time in GTBIT history) "
										+"that people finally started to recognize the DLC. The rest, is history. DLC has always been driven "
										+"by passion and never numbers. Under the able guidance of the convener, Mrs. Seema Singh, DLC members "
										+"have constantly strived to create an affluent environment for the literary enthusiasts. DLC strives "
										+"to be the most active society in the college. Since its inception, DLC has been at the helm of "
										+"organizing some of the University’s best and most popular events throughout the year. Ruminations "
										+"(2004), Apprentice (2006) and Mindspeak (2004) are but a few of the inter-college events that have "
										+"seen enormous growth over the years. At the intra-college level, DLC organizes Teachers’ day "
										+"celebrations, Jobplore and Kaleidoscope every year. ";
									
									banner=contextPath+"/img/banners/dlcone.jpg";
									break;
									
			case "IIPC"	:			info="We believe in producing future leaders, not just ordinary businessmen Every heart is filled with "
										+"dreams and hopes. It is these dreams that inspire us to not just breathe, but to aspire for life. "
										+"The Entrepreneurship Development Cell at GTBIT aims to help budding engineers of the institution "
										+"realize their dreams and establish their own startups. EDC maintains relations with various "
										+"industries to provide a huge resource pool. It also maintains relations with bankers, venture "
										+"capitalist and other functional institutions like MSME which provide funding on easy terms. EDC "
										+"has also collaborated with NEN. EDC is presently headed by Mr. Amrish Kumar Maggo and Mr. Amandeep "
										+"Singh who make it a point to steer the society towards greater heights.";
		
									banner=contextPath+"/img/banners/edc.jpg";
									break;
									
			case "Elance"	:		info="E’lance is the fashion society of GTBIT and just as the name suggests, it is a group of self-aware "
										+ "and confident and not to forget, good-looking individuals .The society accommodates people with "
										+ "interests in all kind of fashion-related fields including hair-styling, dress designing, modelling, "
										+ "and so much more. Do you ever find yourself staring in the mirror wondering how good looking you are? "
										+ "Do you have a knack for creating intricate hairstyles or designing prismatic, multihued clothes? If "
										+ "yes, then this is the place for you. We welcome everyone with similar interests. The fashion society "
										+ "gives you a platform to fulfil your dreams and ambitions and show it out to the world as you do. With "
										+ "the dedication and hard work of the members of the society.";
		
									banner=contextPath+"/img/banners/elanceone.jpg";
									break;
									
			case "Epicture":		info="Write... Click... Shoot... Share It all started with an idea -- an idea to give a chance to the creativity "
										+ "and the talent, which everybody has, but is realized for its true potential and worth by only a few. "
										+ "A chance to see your name in print, to share your work with others, whether it is a mere vision, a belief"
										+ ", a thought or an idea. Epicture is all about honing those talents and bringing out that creativity from "
										+ "within. Initially, Epicture was just a group that ran the college magazine – a compilation of pictures, "
										+ "sketches, paintings, cover stories, reviews and poems submitted by the students. Over the one year that it "
										+ "has been functional, its horizons have broadened significantly. We have a team of people who excel in "
										+ "photography. These are supported by a technical team which gives shape to their work. The technical team "
										+ "also shoots documentaries from time to time, designs a theme for the magazine and is currently working on "
										+ "developing an application for the group";
			
									banner=contextPath+"/img/banners/epictureone.jpg";
									break;
									
			case "Etcetra":			info="Etcetra is the cultural society of GTBIT events in the college such as dramas, music and dance competitions "
										+ "ETC ET-CETERA gives an oppurtunity to the students to make their mark in every field. This society aims at "
										+ "the holistic development of the students because we,at GTBIT believe that education is not a mere process of "
										+ "stuffing the heads with information. Rather, it is a process of complete nurturing of the body and soul.";
			
									banner=contextPath+"/img/banners/etcpic.png";
									break;
									
			case "G#":				info="G#, the musical society of the college, performs in various musical events and competitions round the year and "
										+ "bags laudable victories as well. It consists of members from diverse backgrounds and mindsets brought together "
										+ "and driven forward with the one dream of “living the music”. This has been the motto of the society since it "
										+ "came into being. The society with its deeply motivated members has always thrived to create soulful compositions "
										+ "and renditions. It brings to life everything touched by its notes and harmonies.";
			
									banner=contextPath+"/img/banners/gone.jpg";
									break;
									
			case "GFS":				info="GFS, or the GTBIT Finishing School envisages having a positive and enhancing influence on every student, faculty "
										+ "and staff member, during the course of their stay and experience at GTBIT. Our aim is to make each and every "
										+ "student graduating from GTBIT confident, presentable and job ready. We feel that holistic development is the "
										+ "cornerstone of personal, academic, and career success and that the companies that come to GTBIT for placements "
										+ "should not feel the need to reject any student on any basis. Thus, our motive is to bridge the gap between "
										+ "academics and demands of the industry and help to make you job ready by organizing soft skills lectures, workshops, "
										+ "seminars and lots more. At GFS, our aim is to make the students believe in themselves and be confident enough "
										+ "to go out in the fiercely competitive world and emerge out successful and accomplished. And this is the thought "
										+ "we uphold each day as members of the Finishing School. Founded by Ms. Guneet Kaur in 2011.";
			
									banner=contextPath+"/img/banners/gfsone.jpg";
									break;
			
		}
		
		JSONArray arr=new JSONArray();
		JSONObject obj1=new JSONObject();
		JSONObject obj2=new JSONObject();
		JSONObject obj3=new JSONObject();
		obj1.put("sname",q);
		obj2.put("info",info);
		obj3.put("banner",banner);
		arr.put(obj1);
		arr.put(obj2);
		arr.put(obj3);
		PrintWriter out=response.getWriter();
		out.print(arr.toString());
	}
}
