package com.primus.server.ejb;

import com.primus.server.exception.ManagerException;
import com.primus.server.model.BaseModel;

public interface BasePersistenceManager<T extends BaseModel> extends BaseManager<T>
{
	/**
	 */
	public abstract T save(final T model) throws ManagerException;

	/**
	 */
	public abstract T delete(final Long modelID) throws ManagerException;
}