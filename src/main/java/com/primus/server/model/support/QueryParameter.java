package com.primus.server.model.support;

import java.io.Serializable;

import com.primus.server.exception.ValidationException;
import com.primus.server.model.mpi.Validable;

@SuppressWarnings("serial")
public abstract class QueryParameter implements Validable, Serializable
{
	/**
	 */
	@Override
	public void valid() throws ValidationException
	{
	}
}