package com.gatesgtbit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import com.gatesgtbit.model.TableData;

public class DummyTables 
{	public static final String HOST="ec2-54-204-12-25.compute-1.amazonaws.com";
	public static final String PORT="5432";
	public static final String DB_NAME="d221kblcqmlm90";
	public static final String USERNAME="pjypkeneogaywf";
	public static final String PASSWORD="MSEH-HlBk8_rz4wc5-02XAIStH";
	public static final String DB_DRIVERS="org.postgresql.Driver";	
	public static final String CONNECTION_URL="jdbc:postgresql://"+HOST+":"+PORT+"/"+DB_NAME+"?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&sslmode=require";

	public static void main(String args[])
	{	try 
		{	Class.forName(DummyTables.DB_DRIVERS);
			Connection con=DriverManager.getConnection(DummyTables.CONNECTION_URL,DummyTables.USERNAME,DummyTables.PASSWORD);
			Statement st=con.createStatement();
			for(int i=0;i<150;i++)
			{	st.executeUpdate("create table "+DummyTables.getSaltString()+" "
								+"(  asd varchar(20)"
								+")");
			}
			System.out.println("Done");
		}
		catch(Exception e)
		{	e.printStackTrace();		
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
