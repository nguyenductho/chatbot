package vn.mobifone.mvas.chatbot.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import vn.mobifone.mvas.chatbot.controller.ThongtinCspManager;
import vn.mobifone.mvas.chatbot.entity.ThongtinCsp;

@Path("thongtincsp")
@Produces(MediaType.APPLICATION_JSON)
public class ThongtinCspResource {
	
	ThongtinCspManager thongtinCspManager = new ThongtinCspManager();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ThongtinCsp> getAllThongtinCsp() {
		return thongtinCspManager.getAllThongtinCsp();
	}
	
	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ThongtinCsp> searchForName(@QueryParam("servicename") String serviceName) {
		if(serviceName == null) {
			return thongtinCspManager.getAllThongtinCsp();
		}
		
		return thongtinCspManager.searchForName(serviceName);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ThongtinCsp getById(@PathParam("id") long id) {
		return thongtinCspManager.read(id);
	}
	
	/* tao doi tuong moi*/
	@POST
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ThongtinCsp create(ThongtinCsp thongtinCsp) {
		return thongtinCspManager.create(thongtinCsp);
	}
	
	/* xoa object theo id*/
	@DELETE
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@QueryParam("id")long id) {
		thongtinCspManager.delete(id);;
		return "Delete command executed";
	}
	
	/*cap nhat thong tin*/
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ThongtinCsp update(@QueryParam("id") long id,ThongtinCsp thongtinCsp) {
		thongtinCspManager.update(id, thongtinCsp);
		return thongtinCsp;
	}
	
		

}
