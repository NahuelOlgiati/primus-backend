package com.primus.service.manager.local;

import javax.ejb.Local;

import com.ebizlink.pandora2.server.ejb.BasePersistenceManager;
import com.ebizlink.pandora2.server.exception.ManagerException;
import com.primus.model.SystemAgent;
import com.primus.model.composite.Document;

@Local
public interface SystemAgentManagerLocal extends BasePersistenceManager<SystemAgent> {
	/**
	 */
	public abstract SystemAgent get(final Document d);

	/**
	 */
	public abstract SystemAgent getOrCreate(final Document d, final String firstName, final String lastName)
			throws ManagerException;
}