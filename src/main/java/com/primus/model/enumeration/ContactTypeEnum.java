package com.primus.model.enumeration;

import com.primus.server.model.mpi.LabeledValued;
import com.primus.service.msg.DBSMsgHandler;

public enum ContactTypeEnum implements LabeledValued<ContactTypeEnum>
{
	MAIL,
	SMS,
	OTHER;

	/**
	 */
	@Override
	public String getLabel()
	{
		return DBSMsgHandler.getMsg(this);
	}

	/**
	 */
	@Override
	public ContactTypeEnum getValue()
	{
		return this;
	}
}