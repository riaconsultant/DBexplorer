package com.manu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


@Path("/service")
public class TestService {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String Hello() {
		return "<h1>Hello World !!</h1>";
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String sayHello(@FormParam("id") String abc) {
		String arg= abc+"Hello world";
		return arg;
	}
	
	@GET
	@Path("/todos/{todo}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray getTodo(@PathParam("todo") String id) {
		//ArrayList arra=new ArrayList();
		Map<String, String> obj=new HashMap<String, String>();
		for(int k=0;k<50;k++){
			obj.put(k+"",k+"1");
		}
		JSONArray arr=new JSONArray();
		JSONObject obj1=new JSONObject();
		try {
			for(int i=0;i<10;i++){
				obj1.put("val"+i,i);
				arr.put(i,obj);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//arr.put(obj);
		return arr;
	}
	
	@GET
	@Path("/todo")
	@Produces(MediaType.TEXT_HTML)
	public String getTod() {
		return "Hello";
	}
}
