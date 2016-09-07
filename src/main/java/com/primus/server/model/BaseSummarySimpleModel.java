package com.primus.server.model;

import com.primus.core.msg.MessageBuilder;
import com.primus.core.msg.enumeration.ModelMsgEnum;
import com.primus.core.util.CompareUtil;
import com.primus.server.exception.ValidationException;
import com.primus.service.msg.DBSMsgHandler;

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
			mb.addMessage(DBSMsgHandler.getMsg(ModelMsgEnum.INVALID_SUMMARY_DESCRIPTION));
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