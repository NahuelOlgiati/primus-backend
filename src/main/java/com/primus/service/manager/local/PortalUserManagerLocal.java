package com.primus.service.manager.local;

import javax.ejb.Local;

import com.ebizlink.pandora2.server.exception.ManagerException;
import com.primus.model.PortalUser;
import com.primus.model.composite.Document;
import com.primus.model.enumeration.TaxPayerTypeEnum;


@Local
public interface PortalUserManagerLocal extends BaseUserManagerLocal<PortalUser>
{
	/**
	 */
	public abstract PortalUser register(final PortalUser portalUser, final Document document, final TaxPayerTypeEnum taxPayerType)
			throws ManagerException;

	/**
	 */
	public abstract void changeMailAddress(PortalUser portalUser, String newEmailAddress) throws ManagerException;

	/**
	 */
	public abstract void sendPassword(final Document document) throws ManagerException;
}