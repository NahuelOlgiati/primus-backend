package com.primus.rest.endpoint;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ebizlink.pandora2.core.util.CompareUtil;
import com.ebizlink.pandora2.server.ejb.BaseEJB;
import com.ebizlink.pandora2.server.exception.ManagerException;
import com.ebizlink.pandora2.server.model.support.QueryHint;
import com.primus.model.DocumentType;
import com.primus.rest.annotation.RequiredRole;
import com.primus.rest.annotation.Secured;
import com.primus.rest.app.RoleEnum;
import com.primus.rest.util.ResponseUtil;
import com.primus.service.manager.local.DocumentTypeManagerLocal;

@Secured
@Stateless
@Path("/documentType")
public class DocumentTypeEndPoint extends BaseEJB
{
	@EJB
	private DocumentTypeManagerLocal documentTypeML;

	@GET
	@RequiredRole({RoleEnum.ADMIN})
	@Produces(MediaType.APPLICATION_JSON)
	public DocumentType[] get()
	{
		return documentTypeML.getQueryHintResult("", new QueryHint(0, Integer.MAX_VALUE)).getQueryList().toArray(new DocumentType[0]);
	}

	@GET
	@Path("/get:{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id)
	{
		final DocumentType documentType = documentTypeML.get(id);
		if (CompareUtil.isEmpty(documentType))
		{
			return ResponseUtil.notFound();
		}
		return ResponseUtil.success(documentType);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response create(DocumentType documentType)
	{
		Response r = null;
		try
		{
			documentTypeML.save(documentType);
		}
		catch (ManagerException e)
		{
			System.out.println("exception in create " + e);
			r = ResponseUtil.fatalException();
		}
		return r;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response update(DocumentType documentType)
	{
		Response r = null;
		try
		{
			documentTypeML.save(documentType);
		}
		catch (ManagerException e)
		{
			System.out.println("exception in update " + e);
			r = ResponseUtil.fatalException();
		}
		return r;
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteById(@PathParam("id") Long id)
	{
		Response r = null;
		try
		{
			documentTypeML.delete(id);
			r = Response.ok().build();
		}
		catch (Exception e)
		{
			System.out.println("exception in create " + e);
			r = ResponseUtil.fatalException();
		}
		return r;
	}
}
