package com.primus.model.enumeration;

//import com.ebizlink.adonis.common.service.msg.DBSMsgHandler;
import com.ebizlink.pandora2.server.model.mpi.LabeledValued;

public enum TaxPayerTypeEnum implements LabeledValued<TaxPayerTypeEnum>
{
	ALL,
	NATURAL,
	LEGAL;

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
	public TaxPayerTypeEnum getValue()
	{
		return this;
	}

	/**
	 */
	public Boolean getIsAll()
	{
		return this.equals(ALL);
	}

	/**
	 */
	public Boolean getIsNatural()
	{
		return this.equals(NATURAL);
	}

	/**
	 */
	public Boolean getIsNaturalOrAll()
	{
		return this.equals(NATURAL) || this.equals(ALL);
	}

	/**
	 */
	public Boolean getIsLegal()
	{
		return this.equals(LEGAL);
	}

	/**
	 */
	public Boolean getIsLegalOrAll()
	{
		return this.equals(LEGAL) || this.equals(ALL);
	}
}