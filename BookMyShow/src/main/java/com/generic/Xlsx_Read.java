package com.generic;

import java.io.FileInputStream;



public class Xlsx_Read {

	String path;
	public FileInputStream fis;
	
	public Xlsx_Read(String path){
		this.path=path;
		try{
			fis = new FileInputStream(path);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
