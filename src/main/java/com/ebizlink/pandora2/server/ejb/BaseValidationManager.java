package com.ebizlink.pandora2.server.ejb;

import com.ebizlink.pandora2.core.exception.BaseException;
import com.ebizlink.pandora2.server.model.BaseModel;

public interface BaseValidationManager
{
	/**
	 */
	public abstract <T extends BaseModel> void valid(T model) throws BaseException;
}