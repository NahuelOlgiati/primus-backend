package com.primus.model.enumeration;

//import com.ebizlink.adonis.common.service.msg.DBSMsgHandler;
import com.ebizlink.pandora2.server.model.mpi.LabeledValued;

public enum GenderEnum implements LabeledValued<GenderEnum>
{
	MALE,
	FEMALE;

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
	public GenderEnum getValue()
	{
		return this;
	}
}