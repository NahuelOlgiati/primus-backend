package com.primus.model.enumeration;

import com.ebizlink.pandora2.server.model.mpi.LabeledValued;

public enum PhoneTypeEnum implements LabeledValued<PhoneTypeEnum>
{
	HOME,
	MOBILE,
	OFFICE,
	FAX,
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
	public PhoneTypeEnum getValue()
	{
		return this;
	}
}