package com.example.uwfood;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.nodes.Element;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class Outlet {

	private String title = null;
	private String description = null;
	private String hoursOfOperation = null;
	private String notes = null;
	private String exceptions = null;
	private Bitmap image = null;
	private Element ele = null;
	private boolean debit = false; 


	//Receiving the element with the <div class="views-row">
	public Outlet(Element ele){
		
		this.ele = ele;

		//Title is contained in <div class="views-field-title">
		if (!ele.select(".views-field-title").text().toString().isEmpty()) 
			title = ele.select(".views-field-title").text().toString(); 
		else
			title = "";  

		//Description is contained in <div class="views-field-field-description">
		if (!ele.select(".field-content").text().toString().isEmpty()) 
			description = ele.select(".field-content").text().toString(); 
		else
			description = ""; 

		//Hours of operation is contained in <div class="oh-display-grouped">
		if (!ele.select(".oh-display-grouped").text().toString().isEmpty()) 
			hoursOfOperation = ele.select(".oh-display-grouped").text().toString(); 
		else
			hoursOfOperation = "";
		
		//Notes is contained in <div class="views-field-field-hours-notice">
		if (!ele.select(".views-field-field-hours-notice").text().toString().isEmpty()) 
			notes = ele.select(".views-field-field-hours-notice").text().toString(); 
		else
			notes = "";
		
		//Exceptions are contained in <ul class="exceptions_list">
		if (!ele.select(".exceptions_list").text().toString().isEmpty()) 
			exceptions = ele.select(".exceptions_list").text().toString(); 
		else
			exceptions = "";
		
		
		//Debit is contained in the <div class="views-field-field-description"> but not in its own wrapper with a class
		//Look for the debit substring
		debit = ele.select(".views-field-field-description").text().toString().contains("Debit accepted");
		
		//TODO: Image store it as a bitmap
//		Log.e("Image", "IMG URL" + ele.select("img").first().absUrl("src"));
//		try {
//			URL url = new URL(ele.select("img").first().absUrl("src"));
//			image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//			Log.e("Image", "LOADED IMAGE");
//		} catch (MalformedURLException e) {
//			image = null;
//			e.printStackTrace();
//		} catch (IOException e){
//			image = null;
//			e.printStackTrace();
//		}


	}

	public Element getElement() {
		return ele;
	}
	
	public String getTitle() {
		return title;
	}


	public String getDescription() {
		return description;
	}


	public String getHoursOfOperation() {
		return hoursOfOperation;
	}


	public String getNotes() {
		return notes;
	}


	public String getExceptions() {
		return exceptions;
	}


	public Bitmap getImage() {
		return image;
	}


	public boolean isDebit() {
		return debit;
	}

}
