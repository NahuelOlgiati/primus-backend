package com.primus.rest.endpoint;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Bob McWhirter
 */
@Path("/test")
public class MyResource {

	@GET
	@Path("/text")
	@Produces("text/plain")
	public String get() {
		return "Howdy at " + new Date();
	}
}
