package com.primus.service.manager.local;

import java.util.List;

import com.primus.model.Profile;
import com.primus.model.User;
import com.primus.model.composite.Document;
import com.primus.server.ejb.BasePersistenceManager;
import com.primus.server.ejb.BaseSimpleManager;
import com.primus.server.exception.ManagerException;
import com.primus.server.model.support.QueryHint;
import com.primus.server.util.QueryHintResult;

public interface BaseUserManagerLocal<T extends User> extends BasePersistenceManager<T>, BaseSimpleManager<T>
{
	/**
	 */
	public abstract T getCurrent();

	/**
	 */
	public abstract T get(final String userName);

	/**
	 */
	public abstract T getFULL(String userName);

	/**
	 */
	public abstract T get(final Document d);

	/**
	 */
	public abstract List<T> getList(final Profile profile);

	/**
	 */
	public abstract QueryHintResult<T> getQueryHintResult(final Boolean excludeReserved, final Boolean active, final String description,
			final QueryHint queryHint);

	/**
	 */
	public abstract QueryHintResult<T> getQueryHintResult(final Boolean active, final String description, final QueryHint queryHint);

	/**
	 */
	public abstract void validSystemAgentDuplication(Document document) throws ManagerException;
}