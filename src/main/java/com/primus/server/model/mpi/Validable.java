package com.primus.server.model.mpi;

import com.primus.server.exception.ValidationException;

public interface Validable
{
	/**
	 */
	public abstract void valid() throws ValidationException;
}