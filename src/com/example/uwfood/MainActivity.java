package com.example.uwfood;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity implements ParserResponse{

	private JSONObject jsonObject = null; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		UWHoursAndLocation hours = new UWHoursAndLocation (false);
		hours.connect();
	}

	public void onParseComplete(JSONObject json){

		this.jsonObject = json;
		printJSON();

	}

	public void onParseComplete(ArrayList<JSONObject> outlets){


	}
	
	public void printJSON(){

		
		
	}


}
