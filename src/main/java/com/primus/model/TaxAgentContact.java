package com.primus.model;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import com.primus.model.composite.Contact;
import com.primus.server.exception.ValidationException;
import com.primus.server.model.BaseModel;

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class TaxAgentContact extends BaseModel
{
	@Id
	@SequenceGenerator(name = "id", sequenceName = "adonis_erp_taxagentcontact_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id")
	private Long taxAgentContactID;

	@Embedded
	private Contact contact;

	/**
	 */
	protected TaxAgentContact(Contact contact)
	{
		this.taxAgentContactID = 0l;
		this.contact = contact;
	}

	/**
	 */
	@Override
	public Long getID()
	{
		return taxAgentContactID;
	}

	/**
	 */
	@Override
	public void setID(Long id)
	{
		this.taxAgentContactID = id;
	}

	/**
	 */
	public Contact getContact()
	{
		if (contact == null)
		{
			contact = new Contact();
		}
		return contact;
	}

	/**
	 */
	@Override
	public void valid() throws ValidationException
	{
		getContact().valid();
	}

	/**
	 */
	@Override
	public String getFullDescription()
	{
		return getContact().getFullDescription();
	}

	/**
	 */
	@Override
	public int hashCode()
	{
		return getContact().hashCode();
	}

	/**
	 */
	@Override
	public boolean equals(Object to)
	{
		return getContact().equals(((TaxAgentContact) to).getContact());
	}
}