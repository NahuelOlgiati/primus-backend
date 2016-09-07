package com.primus.model.enumeration;

import com.primus.server.model.mpi.LabeledValued;

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
//		return DBSMsgHandler.getMsg(this);
		return null;
	}

	/**
	 */
	@Override
	public ContactTypeEnum getValue()
	{
		return this;
	}
}