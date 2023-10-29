package main;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import DAO.UserDAO;
import entities.User;




@Path("/sampleservice")
public class SampleService {
	

	@GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello World";    
    }
	
	@GET
    @Path("/helloworld")
    @Produces("text/plain")
    public String helloWorld(){
        return "Hello World New";    
    }
	
	@GET
    @Path("/echo/{message}")
    @Produces("text/plain")
    public String echo(@PathParam("message")String message){
        return message;  
    }
	
	@GET
    @Path("/newEcho/{message}")
    @Produces("text/plain")
    public String newEcho(@PathParam("message")String message){
        return message;  
    }

	
	//post using xml
	    @POST
	    @Path("/createUser")
	     @Consumes("application/xml")
	     @Produces("application/xml")
	    public User createUser(User user) {
	        // Call UserDAO to persist the user
	        UserDAO uDAO = new UserDAO();
	        uDAO.persist(user);
	        return user;
	    }
	
	//get using xml
	    @GET
	    @Path("/getUsers")
	     @Produces("application/xml")
	    public List<User> getUsers() {
	        // Call UserDAO to retrieve a list of users
	        UserDAO uDAO = new UserDAO();
	        return uDAO.getAllUsers();
	    }
	
	    @GET
	    @Path("/getUser/{name}")
	    @Produces("application/json")
	    public User getUser(@PathParam("name") String name) {
	        // Call UserDAO to retrieve a user by ID
	        UserDAO userDAO = new UserDAO();
	        return userDAO.getUserByName(name);
	    }


	    @PUT
	    @Path("/updateUser")
	    @Consumes("application/json")
	    public User updateUser(User user) {
	        // Call UserDAO to update the user
	        UserDAO userDAO = new UserDAO();
	        return userDAO.merge(user);
	    }
	    
	    @DELETE
	    @Path("/deleteUser/{id}")
	    @Consumes("application/json")
	    public String deleteUser(@PathParam("id") int id) {
	        // Call UserDAO to delete the user
	        UserDAO uDAO = new UserDAO();
	        User user = uDAO.getUserByID(id);
	        if (user != null) {
	            uDAO.remove(user);
	            return "User with ID " + id + " deleted.";
	        } else {
	            return "User with ID " + id + " not found.";
	        }
	    }

	
}