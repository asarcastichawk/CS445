package org.huzair.rest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.huzair.boundary_interfaces.CustomerBI;
import org.huzair.boundary_interfaces.DeliveryBI;
import org.huzair.entities.Order;
import org.huzair.use_cases.CustomerManager;
import org.huzair.use_cases.DeliveryManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path ("/delivery")
public class RESTDelivery {
	
	private DeliveryBI bi = new DeliveryManager();
	private CustomerBI cust_bi = new CustomerManager();
	Gson gson = new Gson();
	JsonObject json = new JsonObject();

	@Path("{oid}")
	@POST
    public Response cancelOrder(@PathParam("oid") String oid, String json_in) {
		Order order;
		order = cust_bi.viewById(oid);
		if(order==null)
			return Response.status(Response.Status.NOT_FOUND).build();
		try{
			order = gson.fromJson(json_in, Order.class);
		}
		catch(Exception e){	
			return Response.status(400).entity(gson.toJson(e)).build();
		}
			
		bi.UpdateStatus(oid, order.getStatus());
		return Response.status(200).build();
	}
}
