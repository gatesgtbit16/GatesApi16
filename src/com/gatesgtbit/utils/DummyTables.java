package com.gatesgtbit.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;

public class DummyTables 
{	public static final String HOST="ec2-54-83-57-25.compute-1.amazonaws.com";
	public static final String PORT="5432";
	public static final String DB_NAME="d7d7u6r32rp2pb";
	public static final String USERNAME="lbwiyhpiuhcwhs";
	public static final String PASSWORD="rEiKYkYxcgjhd-eStzdHLlO4rM";
	public static final String DB_DRIVERS="org.postgresql.Driver";	
	public static final String CONNECTION_URL="jdbc:postgresql://"+HOST+":"+PORT+"/"+DB_NAME+"?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&sslmode=require";

	public static void main(String args[])
	{	File file=new File("HashSet.txt");
		if(file.exists())
		{	try 
			{	Class.forName(DummyTables.DB_DRIVERS);
				Connection con=DriverManager.getConnection(DummyTables.CONNECTION_URL,DummyTables.USERNAME,DummyTables.PASSWORD);
				ObjectInputStream oin=new ObjectInputStream(new FileInputStream(file));
				Object obj=oin.readObject();
				if(obj instanceof HashMap)
				{	HashMap<String,String> HM=(HashMap<String, String>)obj;
					for(String key:HM.keySet())
					{	System.out.println(key);
						Statement st=con.createStatement();
						st.executeUpdate("create table "+key+" as select * from hack");
						st.close();
					}
				}
				oin.close();
				con.close();
			} 
			catch (Exception e) 
			{	e.printStackTrace();
			}
		}
	}
	
	protected static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
