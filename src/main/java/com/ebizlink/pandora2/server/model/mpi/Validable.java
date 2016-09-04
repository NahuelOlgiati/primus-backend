package com.ebizlink.pandora2.server.model.mpi;

import com.ebizlink.pandora2.server.exception.ValidationException;

public interface Validable
{
	/**
	 */
	public abstract void valid() throws ValidationException;
}