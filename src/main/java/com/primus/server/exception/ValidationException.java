package com.primus.server.exception;

import java.util.List;
import javax.ejb.ApplicationException;

import com.primus.core.exception.BaseException;

@ApplicationException(rollback = true)
@SuppressWarnings("serial")
public final class ValidationException extends BaseException
{
	/**
	 */
	public ValidationException(List<String> messages)
	{
		super(messages);
	}

	/**
	 */
	public ValidationException(String message)
	{
		super(message);
	}
}