package com.primus.server.ejb;

import com.primus.server.model.BaseRevisionModel;

public interface BaseRevisionManager<T extends BaseRevisionModel>
{
	/**
	 */
	public abstract Class<T> getRevisionModelClass();
}