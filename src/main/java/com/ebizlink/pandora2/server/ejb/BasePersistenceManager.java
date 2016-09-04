package com.ebizlink.pandora2.server.ejb;

import com.ebizlink.pandora2.server.exception.ManagerException;
import com.ebizlink.pandora2.server.model.BaseModel;

public interface BasePersistenceManager<T extends BaseModel> extends BaseManager<T>
{
	/**
	 */
	public abstract T save(final T model) throws ManagerException;

	/**
	 */
	public abstract T delete(final Long modelID) throws ManagerException;
}