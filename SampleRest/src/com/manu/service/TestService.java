package com.manu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.automation.bean.CreateDoExample;
import com.automation.dto.FieldNameType;
import com.automation.dto.MainDto;
import com.automation.dto.RequestBeanDto;
import com.automation.dto.RequestDto;
import com.automation.util.JSONUtil;
import com.incture.automate.ClientRequestDto;
import com.incture.automate.Format;
import com.incture.automate.FormatFactory;


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
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public MainDto getTod() {
		MainDto maindto = new MainDto();
		RequestDto rdto =new RequestDto();
		RequestDto rdto2 =new RequestDto();
		FieldNameType ft = new FieldNameType();
		ft.setName("sid");
		ft.setType("String");
		
		List<FieldNameType> listf = new ArrayList<FieldNameType>();
		listf.add(ft);
		listf.add(ft);
		List<RequestDto> rlist =new ArrayList<RequestDto>();
		rdto.setDtoName("com.incture.RequestDto");
		rdto.setFieldCount(2);
		rdto.setFieldTypeName(listf);
		rdto2.setDtoName("com.incture.ResponseDto");
		rdto2.setFieldCount(2);
		rdto2.setFieldTypeName(listf);
		rlist.add(rdto);
		rlist.add(rdto2);
		maindto.setRequestdto(rlist);
		RequestBeanDto bdto = new RequestBeanDto();
		bdto.setBeanName("bb");
		List<RequestBeanDto> bdtolist = new ArrayList<RequestBeanDto>();
		bdtolist.add(bdto);
		bdtolist.add(bdto);
		maindto.setRequestBeandto(bdtolist);
		return maindto;
	}
	
	@POST
	@Path("/generate")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String  getTodo(MainDto maindto) {
		CreateDoExample obj = new CreateDoExample();
		System.out.println(maindto.getRequestBeandto()+"==="+maindto.getRequestdto());
		//obj.createDirectory(maindto);
		return "SUccess";
	}
	
	
	@POST
	@Path("/createFile")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public String fileCreation(ClientRequestDto requestMaindto) {
		// Get a DTO having Type of Class to create (DO,DTO,DAO)
		
		JSONUtil.createProjectFile(requestMaindto.getReqProject().getpName());
		System.out.println("inside fileCreation()... calling getShape()");
		FormatFactory.getFormat(requestMaindto);
		JSONUtil.createProjectJsonFile(requestMaindto);
		return "Success";
	}
}
