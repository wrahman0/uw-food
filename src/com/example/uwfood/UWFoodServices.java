package com.example.uwfood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

public class UWFoodServices {

	private static final String url = "https://api.uwaterloo.ca/v2/foodservices/2013/12/menu.json?key=";
	private static final String KEY = "1775694fa7f453e7f7605169f8d6fab1";
	private JSONObject response = null;
	
	private ParserResponse listener;

	public UWFoodServices(ParserResponse listener, boolean flag){
		this.listener = listener;
		if(flag) connect();
	}
	
	public void connect(){
		new MyAsyncTask().execute(url+KEY);
	}

	public JSONObject getResponse(){
		return this.response;
	}
	
	public void setResponse(JSONObject response){
		this.response = response;
	}

	private class MyAsyncTask extends AsyncTask<String, String, String>{
		@Override
		protected String doInBackground(String... args) {
			try {	
				URL currURL = new URL(url+KEY);
				URLConnection connection = currURL.openConnection();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine())!=null){
					response.append(line);
				}
				JSONObject json;
				json = new JSONObject(response.toString());
				setResponse(json);
				bufferedReader.close();
				return null;

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}catch (IOException e){
				e.printStackTrace();
			}catch (JSONException e) {
				e.printStackTrace();
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			
			listener.onParseComplete(getResponse());
			
		}
	}


}
