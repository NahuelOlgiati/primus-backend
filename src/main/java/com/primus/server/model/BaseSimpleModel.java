package com.primus.server.model;

import com.primus.core.msg.enumeration.ModelMsgEnum;
import com.primus.core.util.CompareUtil;
import com.primus.server.exception.ValidationException;
import com.primus.service.msg.DBSMsgHandler;

@SuppressWarnings("serial")
public abstract class BaseSimpleModel extends BaseModel
{
	/**
	 */
	public abstract String getDescription();

	/**
	 */
	public abstract void setDescription(String description);

	/**
	 */
	@Override
	public void valid() throws ValidationException
	{
		if (CompareUtil.isEmpty(getDescription()))
		{
			throw new ValidationException(DBSMsgHandler.getMsg(ModelMsgEnum.INVALID_DESCRIPTION));
		}
	}

	/**
	 */
	@Override
	public String getFullDescription()
	{
		return getDescription();
	}
}