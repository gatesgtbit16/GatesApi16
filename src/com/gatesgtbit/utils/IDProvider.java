package com.gatesgtbit.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;

public class IDProvider 
{	//public static final String HOST="ec2-54-204-12-25.compute-1.amazonaws.com";
//	public static final String PORT="5432";
//	public static final String DB_NAME="d221kblcqmlm90";
//	public static final String USERNAME="pjypkeneogaywf";
//	public static final String PASSWORD="MSEH-HlBk8_rz4wc5-02XAIStH";
//	public static final String DB_DRIVERS="org.postgresql.Driver";	
//	public static final String CONNECTION_URL="jdbc:postgresql://"+HOST+":"+PORT+"/"+DB_NAME+"?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&sslmode=require";
	
	public static void main(String argsp[])
	{	File file=new File("HashSet.txt");
		if(file.exists())
		{	try 
			{	//Class.forName(DummyTables.DB_DRIVERS);
				//Connection con=DriverManager.getConnection(IDProvider.CONNECTION_URL,IDProvider.USERNAME,IDProvider.PASSWORD);
				ObjectInputStream oin=new ObjectInputStream(new FileInputStream(file));
				Object obj=oin.readObject();
				if(obj instanceof HashMap)
				{	HashMap<String,String> HM=(HashMap<String, String>)obj;
					for(String key:HM.keySet())
					{	System.out.println(HM.get(key)+":"+key);
//						st.executeUpdate("insert into eventsandbox values('"+HM.get(key)+"','"+key+"')");
//						PreparedStatement st=con.prepareStatement("insert into eventsandbox values(?,?)");
//						st.setString(1,HM.get(key));
//						st.setString(2,key);
//						st.executeUpdate();
//						st.close();
					}
				}
				oin.close();
				//con.close();
			} 
			catch (Exception e) 
			{	e.printStackTrace();
			}
		}
	}	
}
