package com.ebizlink.pandora2.server.model.support;

import java.io.Serializable;
import com.ebizlink.pandora2.server.exception.ValidationException;
import com.ebizlink.pandora2.server.model.mpi.Validable;

@SuppressWarnings("serial")
public abstract class OperationParameter implements Validable, Serializable
{
	/**
	 */
	@Override
	public void valid() throws ValidationException
	{
	}
}