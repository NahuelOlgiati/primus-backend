package com.primus.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.primus.model.embeddable.Phone;

@Entity
@Table(name = "osiris_tax_taxpayerphone")
@SuppressWarnings("serial")
public class TaxPayerPhone extends TaxAgentPhone
{
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "agentID", insertable = false, updatable = false)
	private TaxPayer taxPayer;

	/**
	 */
	public TaxPayerPhone(Phone phone)
	{
		super(phone);
		this.taxPayer = null;
	}

	/**
	 */
	public TaxPayerPhone()
	{
		this(null);
	}

	/**
	 */
	public TaxPayer getTaxPayer()
	{
		return taxPayer;
	}
}