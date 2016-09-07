package com.primus.service.manager.local;

import com.primus.model.embeddable.Document;
import com.primus.model.msc.Agent;
import com.primus.server.ejb.BasePersistenceManager;

public interface AgentManagerLocal<T extends Agent> extends BasePersistenceManager<T>
{
	/**
	 */
	public abstract T get(final Document document);
}