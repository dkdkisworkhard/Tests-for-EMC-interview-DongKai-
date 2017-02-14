package com.dk.emcinterview.test3;

import java.util.HashMap;
import java.util.Iterator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("StorageArray")
public class Test3 {
        public static HashMap<String , Integer> LUNlist = new HashMap<String, Integer>();
        
        //http://localhost:8080/emctest3/rest/StorageArray/createlun?lunname=dk&lunsize=100
        @GET
        @Path("/createlun")
        @Produces(MediaType.TEXT_XML)
        public synchronized String createLUN(@QueryParam("lunname") String lunname,
                        @QueryParam("lunsize") int lunsize) {
                if (LUNlist.containsKey(lunname)) {
                        return "<lun>" + "The lun " + lunname
                                        + " is exist, not need to create a new one!!! " + "</lun>";
                } else {

                        LUNlist.put(lunname, lunsize);
                        return "<lun>" + "lun " + lunname + " has been created, it's size is " + lunsize
                                        + "</lun>";
                }
        }
        
        
        //http://localhost:8080/emctest3/rest/StorageArray/resizelun?lunname=dk&lunsize=200
        @GET
        @Path("/resizelun")
        @Produces(MediaType.TEXT_XML)
        public synchronized String resizeLUN(@QueryParam("lunname")String lunname,
                                        @QueryParam("lunsize")int newlunsize){
                if (LUNlist.containsKey(lunname)) {
                        
                LUNlist.put(lunname, newlunsize);
                return  "<newlun>" + "lunname: " + lunname + "  lunsize: " + LUNlist.get(lunname) + "</newlun>";
        
                }else {
                        return  "<newlun>" + "lun " + lunname + " is not exist!!! " + "</newlun>";
                }
        }
        
        //http://localhost:8080/emctest3/rest/StorageArray/removelun?lunname=dk
        @GET
        @Path("/removelun")
        @Produces(MediaType.TEXT_XML)
        public synchronized String removeLUN(@QueryParam("lunname")String lunname){
                if (LUNlist.containsKey(lunname)) {
                        LUNlist.remove(lunname);
                        if (LUNlist.containsKey(lunname)) {
                                return "<removelun>" + "remove " + lunname + " failed!!!"
                                                + "</removelun>";
                        } else {
                                return "<removelun>" + "Success!! " + lunname
                                                + " has been removed!" + "</removelun>";
                        }
                }else {
                        return "<removelun>" + lunname
                                        + " id not exist, no need to remove!" + "</removelun>";
                }
        }
        
        //http://localhost:8080/emctest3/rest/StorageArray/retrievelun?lunname=dk
        @GET
        @Path("/retrievelun")
        @Produces(MediaType.TEXT_XML)
        public String retrieveLUN(@QueryParam("lunname")String lunname){
                if (LUNlist.containsKey(lunname)) {
                        return "<retrievelun>" + "The size of " + lunname + " is "+LUNlist.get(lunname) +"</retrievelun>";
                }else {
                        return "<removelun>" + lunname
                                        + " id not exist, can't retrieve it's size!" + "</removelun>";
                }
        }
        
        public static void main(String[] args) {
//              LUNlist.put("123", 123);
                Iterator<String> iter = LUNlist.keySet().iterator();
                while (iter.hasNext()) {
                        System.out.println(LUNlist.get(iter.next()));
                }
        }
        
        
        
}
