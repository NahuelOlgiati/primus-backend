package com.primus.rest.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.primus.core.util.CompareUtil;
import com.primus.model.DocumentType;
import com.primus.model.NaturalTaxPayer;
import com.primus.model.PortalUser;
import com.primus.model.Profile;
import com.primus.model.SystemAgent;
import com.primus.model.embeddable.Document;
import com.primus.rest.app.AuthenticationContext;
import com.primus.rest.util.ResponseUtil;
import com.primus.server.ejb.BaseEJB;
import com.primus.server.exception.ManagerException;
import com.primus.server.exception.ValidationException;
import com.primus.service.manager.local.DocumentTypeManagerLocal;
import com.primus.service.manager.local.NaturalTaxPayerManagerLocal;
import com.primus.service.manager.local.PortalUserManagerLocal;
import com.primus.service.manager.local.SystemAgentManagerLocal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Stateless
@Path("/authentication")
@Api(value = "authentication")
public class AuthenticationEndPoint extends BaseEJB {
	@Inject
	private AuthenticationContext authenticationCTX;

	@EJB
	private NaturalTaxPayerManagerLocal naturalTaxPayerML;
	@EJB
	private DocumentTypeManagerLocal documentTypeML;
	@EJB
	private SystemAgentManagerLocal systemAgentML;
	@EJB
	private PortalUserManagerLocal portalUserML;

	@POST
	@Path("/signup")
	@ApiOperation(value = "signup", notes = "Crea Cuenta de user")
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input", response = Response.class) })
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response signup(@ApiParam @FormParam("email") String email, @ApiParam @FormParam("username") String username,
			@ApiParam @FormParam("password") String password) {
		try {
			// final PortalUser newPortalUser = getDummyNewPortalUser(email,
			// username, password);
			// portalUserML.save(newPortalUser);
			// em.flush();
			// return Response.ok(newPortalUser).build();
			PortalUser full = portalUserML.getFULL(username);
			full.getTaxPayer().initLazyElements();
			// return Response.ok(successResponse("CACA")).build();

			List<String> messages = new ArrayList<String>();
			messages.add("PUM1");
			messages.add("PUM2");
			messages.add("PUM3");
			ValidationException v = new ValidationException(messages);
			return ResponseUtil.exceptionMessage(v.getMessages());
		}
		// catch (ManagerException e)
		// {
		// final String errorResponse =
		// errorResponse(e.getMessages().toString());
		// return
		// Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorResponse).type(MediaType.APPLICATION_JSON).build();
		// }
		catch (Exception e) {
			return ResponseUtil.fatalException();
		}
	}

	/**
	 */
	private PortalUser getDummyNewPortalUser(String email, String username, String password) throws ManagerException {
		final NaturalTaxPayer naturalTaxPayer = naturalTaxPayerML.get(23l);
		final DocumentType documentType = documentTypeML.get(1l);
		final SystemAgent systemAgent = new SystemAgent(new Document(documentType, "212121212121"), username, "caca");
		final SystemAgent systemAgentManaged = systemAgentML.getOrCreate(systemAgent.getDocument(),
				systemAgent.getFirstName(), systemAgent.getLastName());
		final PortalUser newPortalUser = new PortalUser(username, password, new ArrayList<Profile>(), email,
				naturalTaxPayer);
		newPortalUser.setSystemAgent(systemAgentManaged);
		return newPortalUser;
	}

	@POST
	@Path("/signin")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response signin(@FormParam("username") String username, @FormParam("password") String password,
			@Context HttpServletRequest servletRequest) {
		try {
			final PortalUser user = portalUserML.getFULL(username);
			if (CompareUtil.isEmpty(user)) {
				return ResponseUtil.notFound();
			}
			user.getTaxPayer().initLazyElements();

			// servletRequest.login(username, password); // Jaas
			String token = authenticationCTX.register(user);
			return ResponseUtil.success(token);
			// } catch (ServletException e) {
			// return ResponseUtil.notFound();
		} catch (Exception e) {
			return ResponseUtil.fatalException();
		}
	}
}