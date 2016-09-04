package com.primus.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.primus.model.mpa.TaxAgentClassification;

@Entity
@Table(name = "osiris_tax_naturaltaxpayercategory")
//@Audited
@Cacheable(value = true)
@SuppressWarnings("serial")
public class NaturalTaxPayerCategory extends TaxAgentClassification
{
	/**
	 */
	public NaturalTaxPayerCategory(String description, String summaryDescription)
	{
		super(description, summaryDescription);
	}

	/**
	 */
	public NaturalTaxPayerCategory()
	{
		this("", "");
	}
}