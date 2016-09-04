package com.primus.model.composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

//import com.ebizlink.adonis.common.service.msg.DBSMsgHandler;
import com.ebizlink.pandora2.core.msg.MessageBuilder;
import com.ebizlink.pandora2.core.util.CompareUtil;
import com.ebizlink.pandora2.server.exception.ValidationException;
import com.ebizlink.pandora2.server.model.mpi.Describable;
import com.ebizlink.pandora2.server.model.mpi.Emptiable;
import com.ebizlink.pandora2.server.model.mpi.Validable;
import com.primus.model.enumeration.PhoneTypeEnum;

@Embeddable
@SuppressWarnings("serial")
public class Phone implements Validable, Emptiable, Describable, Serializable
{
	@Enumerated(EnumType.STRING)
	private PhoneTypeEnum phoneType;

	@Column(length = 10)
	private String phoneCountryCode;

	@Column(length = 50)
	private String phoneCountryArea;

	@Column(length = 30)
	private String phoneNumber;

	/**
	 */
	public Phone(PhoneTypeEnum phoneType, String phoneCountryCode, String phoneCountryArea, String phoneNumber)
	{
		this.phoneType = phoneType;
		this.phoneCountryCode = phoneCountryCode;
		this.phoneCountryArea = phoneCountryArea;
		this.phoneNumber = phoneNumber;
	}

	/**
	 */
	public Phone()
	{
		this(PhoneTypeEnum.HOME, "", "", "");
	}

	/**
	 */
	public PhoneTypeEnum getPhoneType()
	{
		return phoneType;
	}

	/**
	 */
	public void setPhoneType(PhoneTypeEnum phoneType)
	{
		this.phoneType = phoneType;
	}

	/**
	 */
	public String getPhoneCountryCode()
	{
		return phoneCountryCode;
	}

	/**
	 */
	public void setPhoneCountryCode(String phoneCountryCode)
	{
		this.phoneCountryCode = phoneCountryCode;
	}

	/**
	 */
	public String getPhoneCountryArea()
	{
		return phoneCountryArea;
	}

	/**
	 */
	public void setPhoneCountryArea(String phoneCountryArea)
	{
		this.phoneCountryArea = phoneCountryArea;
	}

	/**
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 */
	@Override
	public boolean isBlank()
	{
		return CompareUtil.isEmpty(getPhoneCountryCode()) || CompareUtil.isEmpty(getPhoneCountryArea()) || CompareUtil.isEmpty(getPhoneNumber());
	}

	/**
	 */
	@Override
	public void valid() throws ValidationException
	{
		final MessageBuilder mb = new MessageBuilder();

		if (CompareUtil.isEmpty(getPhoneType()))
		{
//			mb.addMessage(DBSMsgHandler.getMsg(getClass(), "phoneTypeEmpty"));
		}

		if (CompareUtil.isEmpty(getPhoneCountryCode()))
		{
//			mb.addMessage(DBSMsgHandler.getMsg(getClass(), "phoneCountryCodeEmpty"));
		}

		if (CompareUtil.isEmpty(getPhoneCountryArea()))
		{
//			mb.addMessage(DBSMsgHandler.getMsg(getClass(), "phoneCountryAreaEmpty"));
		}

		if (CompareUtil.isEmpty(getPhoneNumber()))
		{
//			mb.addMessage(DBSMsgHandler.getMsg(getClass(), "phoneNumberEmpty"));
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

		if (!CompareUtil.isEmpty(getPhoneNumber()))
		{
			if (!CompareUtil.isEmpty(getPhoneType()))
			{
				sb.append(getPhoneType().getLabel().trim());
				sb.append(": ");
			}

			if (!CompareUtil.isEmpty(getPhoneCountryCode()))
			{
				sb.append("+");
				sb.append(getPhoneCountryCode().trim());
			}

			if (!CompareUtil.isEmpty(getPhoneCountryArea()))
			{
				sb.append(getPhoneCountryArea().trim());
			}

			if (!CompareUtil.isEmpty(sb.toString()))
			{
				sb.append("-");
			}
			sb.append(getPhoneNumber().trim());
		}
		return sb.toString();
	}

	/**
	 */
	@Override
	public int hashCode()
	{
		return getPhoneType().hashCode() + getPhoneCountryCode().hashCode() + getPhoneCountryArea().hashCode() + getPhoneNumber().hashCode();
	}

	/**
	 */
	@Override
	public boolean equals(Object to)
	{
		final Phone p = (Phone) to;
		return getPhoneType().equals(p.getPhoneType()) && getPhoneCountryCode().equals(p.getPhoneCountryCode())
				&& getPhoneCountryArea().equals(p.getPhoneCountryArea()) && getPhoneNumber().equals(p.getPhoneNumber());
	}
}