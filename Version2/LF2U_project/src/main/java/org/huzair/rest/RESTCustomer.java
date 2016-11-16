package org.huzair.rest;

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
import org.huzair.boundary_interfaces.CustomerBI;
import org.huzair.entities.Customer;
import org.huzair.entities.Order;
import org.huzair.use_cases.CustomerManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class RESTCustomer {
	
	private CustomerBI bi = new CustomerManager();
	Gson gson = new Gson();
	JsonObject json = new JsonObject();
	
	@POST
    public Response createAccount(@Context UriInfo uriInfo,String json_in) {
			Customer cust;
			try{
				cust = gson.fromJson(json_in, Customer.class);
			}
			catch(Exception e){
				return Response.status(400).entity(gson.toJson(e)).build();
			}
			if(!cust.validate())
				return Response.status(Response.Status.BAD_REQUEST).build();
			
			String id = bi.createAccount(cust);
			json.addProperty("cid", id);
			
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
	        builder.path(id);
	        return Response.created(builder.build()).entity(json.toString()).build();
		}
	
	@Path("{id}")
	@PUT
    public Response updateAccount(@PathParam("id") String cid, String json_in) {
			Customer cust;
			cust = bi.viewAccount(cid);
			if(cust==null)
				 return Response.status(Response.Status.NOT_FOUND).build();
			try{
				cust = gson.fromJson(json_in, Customer.class);
			}
			catch(Exception e){
				return Response.status(400).entity(gson.toJson(e)).build();
			}
			
			if(!cust.validate())
				return Response.status(Response.Status.BAD_REQUEST).build();
			
			bi.updateAccount(cid, cust);
			return Response.status(200).build(); 
	}
	
	@Path("{id}")
	@GET
    public Response viewAccount(@PathParam("id") String cid) {
			Customer cust;
			cust = bi.viewAccount(cid);
			if(cust==null)
				 return Response.status(Response.Status.NOT_FOUND).build();
			String sjson;
			try{
				sjson = gson.toJson(cust);
			}
			catch(Exception e){	
				return Response.status(400).entity(gson.toJson(e)).build();
			}
			return Response.ok(sjson).build(); 
	}
	@Path("{id}/orders")
	@POST
	public Response createOrder(@Context UriInfo uriInfo, @PathParam("id") String cid, String json_in) {
			
			Customer cust;
			String id;
			cust = bi.viewAccount(cid);
			if(cust==null)
				return Response.status(Response.Status.NOT_FOUND).build();
			Order order;
			try{
				order = gson.fromJson(json_in, Order.class);
			}
			catch(Exception e){	
				return Response.status(400).entity(gson.toJson(e)).build();
			}
			
			if(!order.validate())
				return Response.status(Response.Status.BAD_REQUEST).build();
			
			id = bi.createOrder(cid, order);
			json.addProperty("oid", id );
			
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
	        builder.path(id);
	        
	        return Response.created(builder.build()).entity(json.toString()).build(); 
		}
	
	@Path("{id}/orders")
	@GET
    public Response viewOrders(@PathParam("id") String cid) {
		Customer cust;
		cust = bi.viewAccount(cid);
		if(cust==null)
			return Response.status(Response.Status.NOT_FOUND).build();
		String sjson = gson.toJson(bi.viewAllOrders(cid));
		return Response.ok(sjson).build();
			
	}
	
	@Path("{cid}/orders/{oid}")
	@GET
    public Response viewOrderReport(@PathParam("cid") String cid,@PathParam("oid") String oid) {
		Customer cust;
		cust = bi.viewAccount(cid);
		if(cust==null)
			return Response.status(Response.Status.NOT_FOUND).build();
		String sjson = gson.toJson(bi.viewOrderReport(oid));
		return Response.ok(sjson).build();
			
	}
	@Path("{cid}/orders/{oid}")
	@POST
    public Response cancelOrder(@Context UriInfo uriInfo, @PathParam("cid") String cid,@PathParam("oid") String oid, String json_in) {
		Customer cust;
		int id;
		cust = bi.viewAccount(cid);
		if(cust==null)
			return Response.status(Response.Status.NOT_FOUND).build();
		Order order;
		try{
			order = gson.fromJson(json_in, Order.class);
		}
		catch(Exception e){	
			return Response.status(400).entity(gson.toJson(e)).build();
		}
		if(!order.statusValidate())
			return Response.status(Response.Status.BAD_REQUEST).build();
			
		bi.cancelOrder(cid, oid, order.getStatus());

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(oid);
        
        return Response.ok(builder.build()).build();
	}
	}
	

