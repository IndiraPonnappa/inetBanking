package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig(){
		
		File src= new File("./Configuration/config.properties");
		
		try{
			FileInputStream fis= new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		}
		catch (Exception exp){
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();
			
		}
	} 
	public String getApplicationURL(){
		String Url=pro.getProperty("baseURL");
		return Url;
	}
	public String getUsername(){
		String username=pro.getProperty("username");
		return username;
	}
	public String getPassword(){
		String password=pro.getProperty("password");
		return password;
	}
	public String getChromePath(){
		String ChromePath=pro.getProperty("chromepath");
		return ChromePath;
	}
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}



}
