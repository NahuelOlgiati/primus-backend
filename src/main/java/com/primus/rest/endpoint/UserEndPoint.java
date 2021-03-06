package com.primus.rest.endpoint;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.primus.core.util.CompareUtil;
import com.primus.model.PortalUser;
import com.primus.rest.annotation.RequiredRole;
import com.primus.rest.app.RoleEnum;
import com.primus.rest.util.ResponseUtil;
import com.primus.server.ejb.BaseEJB;
import com.primus.server.exception.ManagerException;
import com.primus.server.model.support.QueryHint;
import com.primus.service.manager.local.PortalUserManagerLocal;

@Stateless
@Path("/user")
public class UserEndPoint extends BaseEJB
{
	@EJB
	private PortalUserManagerLocal portalUserML;

	@GET
	@RequiredRole({RoleEnum.ADMIN})
	@Produces(MediaType.APPLICATION_JSON)
	public PortalUser[] get()
	{
		return portalUserML.getQueryHintResult("", new QueryHint(0, Integer.MAX_VALUE)).getQueryList().toArray(new PortalUser[0]);
	}

	@GET
	@Path("/get:{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id)
	{
		final PortalUser user = portalUserML.getFULL(id);
		if (CompareUtil.isEmpty(user))
		{
			return ResponseUtil.notFound();
		}
		return ResponseUtil.success(user);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response update(PortalUser user)
	{
		Response r = null;
		try
		{
			portalUserML.save(user);
			r = ResponseUtil.success();
		}
		catch (ManagerException e)
		{
			System.out.println("exception in update " + e);
			r = ResponseUtil.fatalException();
		}
		return r;
	}
}