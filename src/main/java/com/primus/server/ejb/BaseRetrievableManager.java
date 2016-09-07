package com.primus.server.ejb;

import java.util.List;

import com.primus.server.model.BaseModel;

public interface BaseRetrievableManager<T extends BaseModel>
{
	/**
	 */
	public abstract List<T> getList();
}