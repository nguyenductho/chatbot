package vn.mobifone.mvas.chatbot.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import vn.mobifone.mvas.chatbot.controller.BriefInfoManager;
import vn.mobifone.mvas.chatbot.entity.BriefInfo;

@Path("briefinfo")
public class BriefInfoResource {
	
	BriefInfoManager briefInfoManager = new BriefInfoManager();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BriefInfo> getAllBriefInfo() {
		return  briefInfoManager.getAllBriefInfo();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public BriefInfo getById(@PathParam("id") long id) {
		return briefInfoManager.read(id);
	}
	
	@GET
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BriefInfo> searchForName(@QueryParam("name") String name) {
		if(name == null) {
			return briefInfoManager.getAllBriefInfo();
		}
		return briefInfoManager.searchForName(name);
	}
	
	/* tao doi tuong moi*/
	@POST
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BriefInfo create(BriefInfo briefInfo) {
		return briefInfoManager.create(briefInfo);
	}
	
	/* xoa object theo id*/
	@DELETE
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@QueryParam("id")long id) {
		briefInfoManager.delete(id);;
		return "Delete command executed";
	}
	
	/*cap nhat thong tin*/
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BriefInfo update(@QueryParam("id") long id,BriefInfo briefInfo) {
		briefInfoManager.update(id, briefInfo);
		return briefInfo;
	}

}
