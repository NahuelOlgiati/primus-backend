package com.ebizlink.pandora2.server.ejb;

import java.util.List;
import com.ebizlink.pandora2.server.model.BaseModel;

public interface BaseRetrievableManager<T extends BaseModel>
{
	/**
	 */
	public abstract List<T> getList();
}