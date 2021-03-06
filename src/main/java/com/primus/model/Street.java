package com.primus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.primus.core.msg.MessageBuilder;
import com.primus.core.util.CompareUtil;
import com.primus.server.exception.ValidationException;
import com.primus.server.model.BaseSimpleModel;

@Entity
@Table(name = "adonis_config_street")
//@Audited
@SuppressWarnings("serial")
public class Street extends BaseSimpleModel
{
	@Id
	@SequenceGenerator(name = "id", sequenceName = "adonis_config_street_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id")
	private Long streetID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cityID")
	private City city;

	@Column(length = 300)
	private String description;

	/**
	 */
	public Street(City city, String description)
	{
		this.streetID = 0l;
		this.city = city;
		this.description = description;
	}

	/**
	 */
	public Street()
	{
		this(null, "");
	}

	/**
	 */
	@Override
	public Long getID()
	{
		return streetID;
	}

	/**
	 */
	@Override
	public void setID(Long id)
	{
		this.streetID = id;
	}

	/**
	 */
	public City getCity()
	{
		return city;
	}

	/**
	 */
	public void setCity(City city)
	{
		this.city = city;
	}

	/**
	 */
	@Override
	public String getDescription()
	{
		return description;
	}

	/**
	 */
	@Override
	public void setDescription(String description)
	{
		this.description = description;
	}

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

		if (CompareUtil.isEmpty(getCity()))
		{
//			mb.addMessage(DBSMsgHandler.getMsg(getClass(), "cityEmpty"));
		}

		if (!mb.isEmpty())
		{
			throw new ValidationException(mb.getMessages());
		}
	}

	/**
	 */
	@Override
	public String getFullDescription()
	{
		final StringBuilder sb = new StringBuilder();

		if (!CompareUtil.isEmpty(getDescription()))
		{
			sb.append(getDescription().trim());
		}

		if (!CompareUtil.isEmpty(getCity()))
		{
			if (!CompareUtil.isEmpty(sb.toString()))
			{
				sb.append(", ");
			}
			sb.append(getCity().getFullDescription());
		}
		return sb.toString();
	}
}