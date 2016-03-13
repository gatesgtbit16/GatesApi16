package com.gatesgtbit.model;

public class TableData 
{	public static final String HOST="ec2-54-235-153-179.compute-1.amazonaws.com";
	public static final String PORT="5432";
	public static final String DB_NAME="d2lavpe7rkr6pn";
	public static final String USERNAME="irgohghfkkuqdn";
	public static final String PASSWORD="04ouSQiwj3-hpjaST6AydN_a7J";
	public static final String DB_DRIVERS="org.postgresql.Driver";	
	public static final String CONNECTION_URL="jdbc:postgresql://"+HOST+":"+PORT+"/"+DB_NAME+"?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&sslmode=require";
}
