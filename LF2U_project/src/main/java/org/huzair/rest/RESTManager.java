package org.huzair.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.huzair.boundary_interfaces.ManagerBI;
import org.huzair.entities.Customer;
import org.huzair.entities.Farmer;
import org.huzair.entities.Manager;
import org.huzair.entities.ProductCatalog;
import org.huzair.entities.StoreProduct;
import org.huzair.use_cases.LF2UManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/managers")
@Produces(MediaType.APPLICATION_JSON)
public class RESTManager {
	
	private ManagerBI bi = new LF2UManager();
	Gson gson = new Gson();
	JsonObject json = new JsonObject();
	
	@Path("/catalog")
	@GET
    public Response viewCatalog() {
		String sjson = gson.toJson(bi.viewCatalog());
		return Response.ok(sjson).build();
	}
	
	@Path("/catalog")
	@POST
	public Response addProduct(String json_in) {
		
			ProductCatalog pcatalog;
			try{
				pcatalog = gson.fromJson(json_in, ProductCatalog.class);
			}
			catch(Exception e){	
				return Response.status(400).entity(gson.toJson(e)).build();
			}
			
			if(!pcatalog.validate())
				return Response.status(Response.Status.BAD_REQUEST).build();
			
			int id = bi.addProduct(pcatalog);
			json.addProperty("gcpid", id );
	        
	        return Response.status(201).entity(json.toString()).build();
		}
	@Path("/catalog/{gcpid}")
	@POST
    public Response updateCatalog(@PathParam("gcpid") int gcpid, String json_in) {
			ProductCatalog pcatalog;
			pcatalog = bi.viewProductById(gcpid);
			if(pcatalog==null)
				 return Response.status(Response.Status.NOT_FOUND).build();
			try{
				pcatalog = gson.fromJson(json_in, ProductCatalog.class);
			}
			catch(Exception e){
				return Response.status(400).entity(gson.toJson(e)).build();
			}
			
			if(!pcatalog.validate())
				return Response.status(Response.Status.BAD_REQUEST).build();
			
			bi.updateProduct(gcpid, pcatalog);
			return Response.status(200).build(); 
	}
	@Path("/accounts")
	@GET
	public Response viewManagers(){
		String sjson = gson.toJson(bi.viewAllManagers());
		return Response.ok(sjson).build();
	}
	@Path("/accounts/{mid}")
	@GET
	public Response viewManagerById(@PathParam("mid") int mid){
		Manager manager;
		manager = bi.viewManagerById(mid);
			
		if(manager==null)
			 return Response.status(Response.Status.NOT_FOUND).build();
		String sjson;
		try{
			sjson = gson.toJson(manager);
		}
		catch(Exception e){	
			return Response.status(400).entity(gson.toJson(e)).build();
		}
		return Response.ok(sjson).build(); 
	}
	@Path("reports")
	@GET
    public Response viewReportType(@PathParam("fid") int fid) {
			String sjson = gson.toJson(bi.allReportTypes());
			return Response.ok(sjson).build(); 
	}

}
