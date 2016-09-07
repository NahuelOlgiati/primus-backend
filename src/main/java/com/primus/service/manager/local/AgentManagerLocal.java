package com.primus.service.manager.local;

import com.primus.model.composite.Document;
import com.primus.model.mpa.Agent;
import com.primus.server.ejb.BasePersistenceManager;

public interface AgentManagerLocal<T extends Agent> extends BasePersistenceManager<T>
{
	/**
	 */
	public abstract T get(final Document document);
}