package com.tcc.gestion_logistica.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonUtil {
	  private JsonUtil() {
	    }

	    public static <T> T jsonToObject(String json, Class<T> c) {
	        return new Gson().fromJson(json, c);
	    }

	    public static String objectToJson(Object obj) {
	        return new Gson().toJson(obj);
	    }

	    public static String prettyJson(String json) {
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        JsonParser jp = new JsonParser();
	        JsonElement je = jp.parse(json);
	        return gson.toJson(je);
	    }
}
