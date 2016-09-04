package com.primus.rest.app;

import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.primus.model.Permit;
import com.primus.model.Profile;
import com.primus.model.User;

/**
 */
public class UserPrincipal implements Principal
{
	private User user;
	private Set<String> roles;
	private Date signinDate;

	/**
	 */
	public UserPrincipal(User user, Date signinDate)
	{
		this.user = user;
		this.roles = new HashSet<String>();
		for (Profile profile : user.getProfiles())
		{
			for (Permit permit : profile.getPermits())
			{
				this.roles.add(permit.getCode());
			}
		}
		this.signinDate = signinDate;
	}

	/**
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 */
	public Set<String> getRoles()
	{
		return roles;
	}

	/**
	 */
	public Date getSigninDate()
	{
		return signinDate;
	}

	/**
	 */
	@Override
	public String getName()
	{
		return getUser().getUserName();
	}
}