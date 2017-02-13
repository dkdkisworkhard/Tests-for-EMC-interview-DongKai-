package com.dk.emcinterview.test3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("UserInfoService")
public class Test1 {
	public static HashMap<String, Integer> LUNlist = new HashMap<String, Integer>();
	
	//create lun: http://192.168.1.6:8080/emctest3/rest/StorageArray/createlun?lunname=dk&lunsize=100
	@GET
	@Path("/createlun")
	@Produces(MediaType.TEXT_XML)
	public synchronized String createLUN(@QueryParam("lunname")String lunname, @QueryParam("lunsize")int lunsize){
		if(LUNsize.containsKsy(lunname)){
			return "<createlun>" + lunname + " has existed, can't create a new one " + </createlun>;
		}else{
			LUNlist.put(lunname, lunsize);
		        return "<createlun>" + "Success!!" + lunname + " has been created!!!" + "</createlun>";
		}
	}
	
	//resizelun: http://192.168.1.6:8080/emctest3/rest/StorageArray/resizelun?lunname=dk&lunsize=200
	@GET
	@Path("/resizelun")
	@Produces(MediaType.TEXT_XML)
	public synchronized String resizeLUN(@QueryParam("lunname")String lunname, @QueryParam("lunsize")int lunsize){
		if(LUNsize.containsKsy(lunname)){
		        LUNlist.put(lunname, lunsize);
			return "<resizelun>" + "The new size of " + lunname + " is " + LUNlist.get(lunname) + </resizelun>;
		}else{
		        return "<resizelun>" + lunname + "is not exist, can't reset it's size!!!" + "</resizelun>";
		}
	}
	
	//retrieve lun: http://192.168.1.6:8080/emctest3/rest/StorageArray/retrievelun?lunname=dk
	@GET
	@Path("/retrievelun")
	@Produces(MediaType.TEXT_XML)
	public String retrieveLUN(@QueryParam("lunname")String lunname){
		if(LUNsize.containsKsy(lunname)){
		        
			return "<retrievelun>" + "The size of " + lunname + " is " + LUNlist.get(lunname) + </retrievelun>;
		}else{
		        return "<retrievelun>" + lunname + "is not exist, can't retrieve it's size!!!" + "</retrievelun>";
		}
	}
	
	//remove lun: http://192.168.1.6:8080/emctest3/rest/StorageArray/removelun?lunname=dk
	@GET
	@Path("/removelun")
	@Produces(MediaType.TEXT_XML)
	public synchronized String removeLUN(@QueryParam("lunname")String lunname){
		if(LUNsize.containsKsy(lunname)){
		        LUNlist.remove(lunname);
			return "<removelun>" + "The lun " + lunname + "has been removed!!!" + </removelun>;
		}else{
		        return "<removelun>" + lunname + "is not exist, can't remove!!!" + "</removelun>";
		}
	}
	
	
}
