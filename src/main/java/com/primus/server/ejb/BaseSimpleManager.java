package com.primus.server.ejb;

import com.primus.server.model.BaseModel;
import com.primus.server.model.support.QueryHint;
import com.primus.server.util.QueryHintResult;

public interface BaseSimpleManager<T extends BaseModel>
{
	/**
	 */
	public abstract QueryHintResult<T> getQueryHintResult(final String description, final QueryHint queryHint);
}