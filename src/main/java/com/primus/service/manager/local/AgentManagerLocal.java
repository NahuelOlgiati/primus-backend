package com.primus.service.manager.local;

import com.ebizlink.pandora2.server.ejb.BasePersistenceManager;
import com.primus.model.composite.Document;
import com.primus.model.mpa.Agent;

public interface AgentManagerLocal<T extends Agent> extends BasePersistenceManager<T>
{
	/**
	 */
	public abstract T get(final Document document);
}