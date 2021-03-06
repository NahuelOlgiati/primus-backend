package com.primus.model.enumeration;

import com.primus.server.model.mpi.LabeledValued;
import com.primus.service.msg.DBSMsgHandler;

public enum GenderEnum implements LabeledValued<GenderEnum> {
	MALE, FEMALE;

	/**
	 */
	@Override
	public String getLabel() {
		return DBSMsgHandler.getMsg(this);
	}

	/**
	 */
	@Override
	public GenderEnum getValue() {
		return this;
	}
}