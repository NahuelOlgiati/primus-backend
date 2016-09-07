package com.primus.service.manager.local;

import javax.ejb.Local;

import com.primus.model.SystemAgent;
import com.primus.model.embeddable.Document;
import com.primus.server.ejb.BasePersistenceManager;
import com.primus.server.exception.ManagerException;

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