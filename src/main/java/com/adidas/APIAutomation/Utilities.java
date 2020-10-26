package com.adidas.APIAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;



public class Utilities {
	
	
//	String currentDirectory = System.getProperty("user.dir");
	File file = new File(System.getProperty("user.dir")+"\\data.properties");
	FileInputStream fis;
	FileOutputStream fos;
	Properties prop = new Properties();

	
	public String getStatus() throws IOException {
		
		fis = new FileInputStream(file);
		prop.load(fis);
		String[] petStatus  = prop.getProperty("status").split(",");
		String available = petStatus[0];
		return available;
	}
	
	public String getUrl() throws IOException {
		fis = new FileInputStream(file);
		prop.load(fis);
		String url = prop.getProperty("url");
		return url;
		
	}
	
	public String getPetName() throws IOException {
		fis = new FileInputStream(file);
		prop.load(fis);
		String petName = prop.getProperty("petName");
		return petName;
		
	}
	
	public String getId() throws IOException {
		fis = new FileInputStream(file);
		prop.load(fis);
		String id = prop.getProperty("ID");
		return id;
		
	}
	
	public void setData(String Id) throws IOException {
		fis = new FileInputStream(file);
		prop.load(fis);
		fis.close();
		fos = new FileOutputStream(file);
		prop.setProperty("ID", Id);
		prop.store(fos, null);
		fos.close();
	}

}
