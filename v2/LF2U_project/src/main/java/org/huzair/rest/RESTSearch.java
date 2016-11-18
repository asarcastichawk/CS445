package org.huzair.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.huzair.entities.Search;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class RESTSearch {

	Gson gson = new Gson();
	JsonObject json = new JsonObject();
	Search search;
	
	@GET
    public Response viewFarmers(@QueryParam ("topic") String topic,@QueryParam ("key") String keyword) {
			search = new Search(topic,keyword);
			String sjson;
			try{
				 sjson = gson.toJson(search.determineTopic());
			}
			catch(Exception e)
			{
				return Response.status(400).entity(gson.toJson(e)).build();
			}
			return Response.ok(sjson).build(); 
	}
}
