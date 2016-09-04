package com.ebizlink.pandora2.server.ejb;

import java.util.List;
import com.ebizlink.pandora2.server.model.BaseParentSimpleModel;
import com.ebizlink.pandora2.server.model.support.QueryHint;

public interface BaseParentSimpleManager<T extends BaseParentSimpleModel<T>> extends BaseSimpleManager<T>
{
	/**
	 */
	public abstract List<T> getLeaveList(final String description, final QueryHint qh);
}