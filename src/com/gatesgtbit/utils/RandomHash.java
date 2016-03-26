package com.gatesgtbit.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomHash {
	
	public static void main(String args[])
	{	HashMap<String,String> HM=new HashMap<>();
		ArrayList<String> ARR=new ArrayList<>();
		File file=new File("/home/localhost/Music/EventList1.txt");
		try 
		{	FileReader fin=new FileReader(file);
			BufferedReader buff=new BufferedReader(fin);
			String start=buff.readLine();
			while(start!=null)
			{	ARR.add(start);
				start=buff.readLine();
			}
			buff.close();
		} 
		catch (FileNotFoundException e) 
		{	e.printStackTrace();
		} 
		catch (IOException e) 
		{	e.printStackTrace();
		}
		
		for(String key:ARR)
		{	String random=RandomHash.getSaltString();
			HM.put(random,key);	
		}
		if(ARR.size()==HM.size())
		{	File file1=new File("HashSet.txt");
			if(!file1.exists())
			{	try {
					file1.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file1));
				out.writeObject(HM);
				System.out.println("Written");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
