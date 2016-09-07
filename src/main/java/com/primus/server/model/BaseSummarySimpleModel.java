package com.ebizlink.pandora2.server.model;

import com.ebizlink.pandora2.core.msg.MessageBuilder;
import com.ebizlink.pandora2.core.msg.enumeration.ModelMsgEnum;
import com.ebizlink.pandora2.core.msg.util.PM;
import com.ebizlink.pandora2.core.util.CompareUtil;
import com.ebizlink.pandora2.server.exception.ValidationException;

@SuppressWarnings("serial")
public abstract class BaseSummarySimpleModel extends BaseSimpleModel
{
	/**
	 */
	public abstract String getSummaryDescription();

	/**
	 */
	public abstract void setSummaryDescription(String summaryDescription);

	/**
	 */
	@Override
	public void valid() throws ValidationException
	{
		final MessageBuilder mb = new MessageBuilder();

		try
		{
			super.valid();
		}
		catch (ValidationException v)
		{
			mb.addMessage(v.getMessages());
		}

		if (CompareUtil.isEmpty(getSummaryDescription()))
		{
			mb.addMessage(PM.getMe().getMsg(ModelMsgEnum.INVALID_SUMMARY_DESCRIPTION));
		}

		if (!mb.isEmpty())
		{
			throw new ValidationException(mb.getMessages());
		}
	}

	/**
	 */
	@Override
	public String getFullDescription()
	{
		final StringBuilder sb = new StringBuilder();

		if (!CompareUtil.isEmpty(getSummaryDescription()))
		{
			sb.append("[");
			sb.append(getSummaryDescription().trim());
			sb.append("]");
		}

		if (!CompareUtil.isEmpty(getDescription()))
		{
			sb.append(getDescription().trim());
		}
		return sb.toString();
	}
}