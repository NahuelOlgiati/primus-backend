package com.primus.server.ejb;

import java.util.List;

import com.primus.server.model.BaseParentSimpleModel;
import com.primus.server.model.support.QueryHint;

public interface BaseParentSimpleManager<T extends BaseParentSimpleModel<T>> extends BaseSimpleManager<T>
{
	/**
	 */
	public abstract List<T> getLeaveList(final String description, final QueryHint qh);
}