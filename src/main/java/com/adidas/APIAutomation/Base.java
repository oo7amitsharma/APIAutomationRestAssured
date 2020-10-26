package com.adidas.APIAutomation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import groovyjarjarpicocli.CommandLine;

public class Base {
	
	public static Object getID;
	public static Object getPetName;
	public static Object getStatus;
	public static HashMap<String, Object> map = new HashMap<String, Object>(); 
	public static HashMap<String, Object> category = new HashMap<String, Object>(); 
	public static ArrayList<Object> photoUrls = new ArrayList<Object>(); 
	public static ArrayList<Object> tags = new ArrayList<Object>();
	public static HashMap<String, Object> tag = new HashMap<String, Object>(); 
	Utilities utilities = new Utilities();

}
