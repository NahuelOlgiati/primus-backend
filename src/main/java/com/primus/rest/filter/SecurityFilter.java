
package com.primus.rest.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import org.jboss.resteasy.core.ResourceMethodInvoker;

import com.primus.rest.annotation.RequiredRole;
import com.primus.rest.annotation.Secured;
import com.primus.rest.app.AuthenticationContext;
import com.primus.rest.app.RoleEnum;
import com.primus.rest.app.UserPrincipal;

@Secured
@Provider
@Priority(Priorities.AUTHORIZATION)
public class SecurityFilter implements ContainerRequestFilter {
	public static final String RESOURCE_METHOD_INVOKER = "org.jboss.resteasy.core.ResourceMethodInvoker";

	@Inject
	private AuthenticationContext authenticationCTX;

	/**
	 */
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String authorization = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (authorization == null || authorization.isEmpty()) {
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).build());
			return;
		}

		String token = authorization.replace("Basic ", "");
		UserPrincipal authenticatedUser = authenticationCTX.getAuthenticatedUser(token);
		if (authenticatedUser == null) {
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).build());
			return;
		}

		requestContext.setSecurityContext(new SecurityContext() {
			@Override
			public boolean isUserInRole(String role) {
				return authenticatedUser.getRoles().contains(role);
			}

			@Override
			public boolean isSecure() {
				return true;
			}

			@Override
			public Principal getUserPrincipal() {
				return authenticatedUser;
			}

			@Override
			public String getAuthenticationScheme() {
				return null;
			}
		});

		ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) requestContext
				.getProperty(RESOURCE_METHOD_INVOKER);
		Method method = methodInvoker.getMethod();

		if (method.isAnnotationPresent(RequiredRole.class)) {
			RequiredRole annotation = method.getAnnotation(RequiredRole.class);
			List<RoleEnum> requiredRoles = Arrays.asList(annotation.value());
			for (RoleEnum role : requiredRoles) {
				if (!requestContext.getSecurityContext().isUserInRole(role.name())) {
					requestContext.abortWith(Response.status(Status.UNAUTHORIZED).build());
					return;
				}
			}
		}
	}
}
