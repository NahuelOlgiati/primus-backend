package com.primus.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.primus.core.msg.MessageBuilder;
import com.primus.model.embeddable.Document;
import com.primus.model.enumeration.TaxPayerTypeEnum;
import com.primus.server.exception.ValidationException;

@Entity
@Table(name = "osiris_tax_taxpayer", uniqueConstraints = @UniqueConstraint(columnNames = {"documentTypeID", "documentNumber"}))
@Inheritance(strategy = InheritanceType.JOINED)
//@Audited
@SuppressWarnings("serial")
public abstract class TaxPayer extends TaxAgent<TaxPayerPhone, TaxPayerContact, TaxPayerBank>
{
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "agentID")
//	@NotAudited
	private List<TaxPayerPhone> phoneList;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "phoneDefaultID")
//	@NotAudited
	private TaxPayerPhone phoneDefault;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "agentID")
//	@NotAudited
	private List<TaxPayerContact> contactList;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contactDefaultID")
//	@NotAudited
	private TaxPayerContact contactDefault;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "agentID")
//	@AuditMappedBy(mappedBy = "taxPayer")
	private List<TaxPayerBank> bankList;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bankDefaultID")
	private TaxPayerBank bankDefault;

	/**
	 */
	protected TaxPayer(Document document)
	{
		super(document);
		this.phoneList = null;
		this.phoneDefault = null;
		this.contactList = null;
		this.contactDefault = null;
		this.bankList = null;
		this.bankDefault = null;
	}

	/**
	 */
	public TaxPayer()
	{
		this(null);
	}

	/**
	 */
	@Override
	public List<TaxPayerPhone> getPhoneList()
	{
		if (phoneList == null)
		{
			phoneList = new ArrayList<TaxPayerPhone>();
		}
		return phoneList;
	}

	/**
	 */
	@Override
	public TaxPayerPhone getPhoneDefault()
	{
		return phoneDefault;
	}

	/**
	 */
	@Override
	public void setPhoneDefault(TaxPayerPhone phoneDefault)
	{
		this.phoneDefault = phoneDefault;
	}

	/**
	 */
	@Override
	public List<TaxPayerContact> getContactList()
	{
		if (contactList == null)
		{
			contactList = new ArrayList<TaxPayerContact>();
		}
		return contactList;
	}

	/**
	 */
	@Override
	public TaxPayerContact getContactDefault()
	{
		return contactDefault;
	}

	/**
	 */
	@Override
	public void setContactDefault(TaxPayerContact contactDefault)
	{
		this.contactDefault = contactDefault;
	}

	/**
	 */
	@Override
	public List<TaxPayerBank> getBankList()
	{
		if (bankList == null)
		{
			bankList = new ArrayList<TaxPayerBank>();
		}
		return bankList;
	}

	/**
	 */
	@Override
	public TaxPayerBank getBankDefault()
	{
		return bankDefault;
	}

	/**
	 */
	@Override
	public void setBankDefault(TaxPayerBank bankDefault)
	{
		this.bankDefault = bankDefault;
	}

	/**
	 */
	public String getFullName()
	{
		return "";
	}

	/**
	 */
	public abstract TaxPayerTypeEnum getTaxPayerType();

	/**
	 */
	@Override
	public void valid() throws ValidationException
	{
		final MessageBuilder mb = new MessageBuilder();

		try
		{
			super.valid();
		}
		catch (ValidationException v)
		{
			mb.addMessage(v.getMessages());
		}

		if (!mb.isEmpty())
		{
			throw new ValidationException(mb.getMessages());
		}
	}
}