package com.ebizlink.pandora2.server.ejb;

import com.ebizlink.pandora2.server.model.BaseRevisionModel;

public interface BaseRevisionManager<T extends BaseRevisionModel>
{
	/**
	 */
	public abstract Class<T> getRevisionModelClass();
}