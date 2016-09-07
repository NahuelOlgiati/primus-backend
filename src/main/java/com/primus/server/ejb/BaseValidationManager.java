package com.primus.server.ejb;

import com.primus.core.exception.BaseException;
import com.primus.server.model.BaseModel;

public interface BaseValidationManager
{
	/**
	 */
	public abstract <T extends BaseModel> void valid(T model) throws BaseException;
}