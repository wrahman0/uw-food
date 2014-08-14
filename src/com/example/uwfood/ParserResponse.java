package com.example.uwfood;

import org.json.JSONObject;

public interface ParserResponse {
	void onParseComplete(JSONObject json);
}
