package com.ebizlink.pandora2.server.ejb;

import com.ebizlink.pandora2.server.model.BaseModel;
import com.ebizlink.pandora2.server.model.support.QueryHint;
import com.ebizlink.pandora2.web.util.QueryHintResult;

public interface BaseSimpleManager<T extends BaseModel>
{
	/**
	 */
	public abstract QueryHintResult<T> getQueryHintResult(final String description, final QueryHint queryHint);
}