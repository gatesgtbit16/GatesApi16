package com.gatesgtbit.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomHash {
	
	public static void main(String args[])
	{	HashMap<String,String> HM=new HashMap<>();
		File file=new File("/home/localhost/Music/EventList1.txt");
		try 
		{	FileReader fin=new FileReader(file);
			BufferedReader buff=new BufferedReader(fin);
			String start=buff.readLine();
			while(start!=null)
			{	start=buff.readLine();
				System.out.println(start);
			}
			buff.close();
		} 
		catch (FileNotFoundException e) 
		{	e.printStackTrace();
		} 
		catch (IOException e) 
		{	e.printStackTrace();
		}
		
		HashSet<String> set=new HashSet<>();
		for(int i=0;i<104;i++)
		{	String random=RandomHash.getSaltString();
			System.out.println(random);
			set.add(random);	
		}
		System.out.println(set.size());
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
