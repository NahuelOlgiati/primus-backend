package com.ebizlink.pandora2.server.model;

import com.ebizlink.pandora2.core.msg.enumeration.ModelMsgEnum;
import com.ebizlink.pandora2.core.msg.util.PM;
import com.ebizlink.pandora2.core.util.CompareUtil;
import com.ebizlink.pandora2.server.exception.ValidationException;

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
			throw new ValidationException(PM.getMe().getMsg(ModelMsgEnum.INVALID_DESCRIPTION));
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