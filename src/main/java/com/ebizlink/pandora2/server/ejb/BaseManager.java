package com.ebizlink.pandora2.server.ejb;

import com.ebizlink.pandora2.server.model.BaseModel;

public interface BaseManager<T extends BaseModel>
{
	/**
	 */
	public abstract Class<T> getModelClass();

	/**
	 */
	public abstract T get(final Long modelID);

	/**
	 */
	public abstract T getFULL(final Long modelID);
}