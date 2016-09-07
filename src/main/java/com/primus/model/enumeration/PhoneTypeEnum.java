package com.primus.model.enumeration;

import com.primus.server.model.mpi.LabeledValued;
import com.primus.service.msg.DBSMsgHandler;

public enum PhoneTypeEnum implements LabeledValued<PhoneTypeEnum> {
	HOME, MOBILE, OFFICE, FAX, OTHER;

	/**
	 */
	@Override
	public String getLabel() {
		return DBSMsgHandler.getMsg(this);
	}

	/**
	 */
	@Override
	public PhoneTypeEnum getValue() {
		return this;
	}
}