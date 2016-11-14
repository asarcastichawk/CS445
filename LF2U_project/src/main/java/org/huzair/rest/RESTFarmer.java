	package org.huzair.rest;
	import org.huzair.boundary_interfaces.FarmerBI;
	import org.huzair.entities.Farmer;
	import org.huzair.entities.StoreProduct;
	import org.huzair.use_cases.FarmerManager;
import org.json.JSONArray;
import org.json.JSONObject;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.PUT;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
	import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;
	import com.google.gson.JsonObject;

	@Path("/farmers")
	@Produces(MediaType.APPLICATION_JSON)
	public class RESTFarmer  {
		
		private FarmerBI bi = new FarmerManager();
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		
		@POST
	    public Response createFarm(@Context UriInfo uriInfo,String json_in) {
				Farmer farm;
				try{ farm = gson.fromJson(json_in, Farmer.class); }
				catch(Exception e){ return Response.status(400).entity(gson.toJson(e)).build(); }
				if(!farm.validate())
					return Response.status(Response.Status.BAD_REQUEST).build();
				int id = bi.createAccount(farm);
				json.addProperty("fid", id);
				UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		        builder.path(Integer.toString(id));
		        return Response.created(builder.build()).entity(json.toString()).build();
			}
		
		@Path("{id}")
		@PUT
	    public Response updateAccount(@PathParam("id") int fid, String json_in) {
				Farmer farm;
				farm = bi.viewAccount(fid);
				if(farm==null)
					 return Response.status(Response.Status.NOT_FOUND).build();
				try{ farm = gson.fromJson(json_in, Farmer.class); }
				catch(Exception e){ return Response.status(400).entity(gson.toJson(e)).build(); }
				if(!farm.validate())
					return Response.status(Response.Status.BAD_REQUEST).build();
				bi.updateAccount(fid, farm);
				return Response.status(200).build(); 
		}
		
		@Path("{id}")
		@GET
	    public Response viewAccount(@PathParam("id") int fid) {
				Farmer farm;
				farm = bi.viewAccount(fid);
				if(farm==null)
					 return Response.status(Response.Status.NOT_FOUND).build();
				String sjson;
				try{ sjson = gson.toJson(farm); }
				catch(Exception e){	return Response.status(400).entity(gson.toJson(e)).build(); }
				return Response.ok(sjson).build(); 
		}

		@GET
	    public Response viewFarmers(@QueryParam ("zip") String zip) {
				String sjson = gson.toJson(bi.viewFarmers(zip));
				return Response.ok(sjson).build(); 
		}

		@Path("{id}/products")
		@GET
	    public Response viewStore(@PathParam("id") int fid) {
			Farmer farm;
			farm = bi.viewAccount(fid);
			if(farm==null)
				 return Response.status(Response.Status.NOT_FOUND).build();
			String sjson = gson.toJson(bi.viewStore(fid));
			return Response.ok(sjson).build();
				
		}
		@Path("{id}/products")
		@POST
		public Response addProduct(@Context UriInfo uriInfo, @PathParam("id") int fid, String json_in) {
				Farmer farm = bi.viewAccount(fid);
				if(farm==null)
					return Response.status(Response.Status.NOT_FOUND).build();
				StoreProduct product;
				try{ product = gson.fromJson(json_in, StoreProduct.class);}
				catch(Exception e){	return Response.status(400).entity(gson.toJson(e)).build();}
				String id = bi.addProduct(fid, product);
				if(!product.validate()||id==null)
					return Response.status(Response.Status.BAD_REQUEST).build();
				json.addProperty("fspid", id );
				UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		        builder.path(id);
		        return Response.created(builder.build()).entity(json.toString()).build(); 
			}
		
		@Path("{fid}/products/{fspid}")
		@GET
	    public Response viewProduct(@PathParam("fid") int fid, @PathParam("fspid") String fspid) {
			Farmer farm;
			farm = bi.viewAccount(fid);
			if(farm==null)
				 return Response.status(Response.Status.NOT_FOUND).build();
			else if(bi.viewStore(fid)==null)
				 return Response.status(Response.Status.NOT_FOUND).build();
			String json;
			try{ json = gson.toJson(bi.viewProduct(fid, "fspid"+fspid)); }
			catch(Exception e){ return Response.status(400).entity(gson.toJson(e)).build(); }
			return Response.ok(json.toString()).build(); 
		}
		
		@Path("{fid}/delivery_charge")
		@GET
	    public Response viewDelivery(@PathParam("fid") int fid) {
				Farmer farm = bi.viewAccount(fid);
				if(farm==null)
					 return Response.status(Response.Status.NOT_FOUND).build();
				double vdelivery = farm.getDeliveryCharge();
				json.addProperty("delivery_charge", vdelivery);
				return Response.ok(json.toString()).build(); 
			}
		
		@Path("{fid}/delivery_charge")
		@POST
	    public Response updateDelivery(@PathParam("fid") int fid, String json_in) {
			Farmer farm = bi.viewAccount(fid);
			if(farm==null)
				 return Response.status(Response.Status.NOT_FOUND).build();
			try{
				JSONObject json = new JSONObject(json_in);
				double x = json.getDouble("delivery_charge");
				farm.setDeliveryCharge(x);
				}
			catch(Exception e){	return Response.status(400).entity(gson.toJson(e)).build(); }
			return Response.status(200).build();  
			}
		
		@Path("{id}/products/{fspid}")
		@POST
	    public Response modifyProduct(@Context UriInfo uriInfo, @PathParam("id") int fid,@PathParam("fspid") String fspid, String json_in) {
				StoreProduct sproduct;
				sproduct = bi.viewProduct(fid, "fspid"+fspid);
				if(sproduct==null)
					return Response.status(Response.Status.NOT_FOUND).build();
				try{ sproduct = gson.fromJson(json_in, StoreProduct.class); }
				catch(Exception e){	return Response.status(400).entity(gson.toJson(e)).build();}
				bi.modifyProduct(fid, "fspid"+fspid, sproduct);
				UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		        return Response.created(builder.build()).entity("").build(); 
		}
	
		@Path("{fid}/reports")
		@GET
	    public Response viewReportType(@PathParam("fid") int fid) {
				String sjson = gson.toJson(bi.allReportTypes());
				return Response.ok(sjson).build(); 
		}
		@Path("/reports")
		@GET
	    public Response viewReport() {
			JSONObject jo = new JSONObject();
			try{
			
			jo.accumulate("f", gson.toJson(bi.viewAccount(1)));
			jo.put("lastName", "Doe");
			}
			catch(Exception e){}
			JSONArray ja = new JSONArray();
			ja.put(jo);

			JSONObject mainObj = new JSONObject();
			try{
			mainObj.put("employees", ja);
			mainObj.put("frid", 1);
			}
			catch(Exception e){}
				return Response.ok(mainObj.toString()).build(); 
		}
	}
