package com.ebizlink.pandora2.core.security.enumeration;

import com.ebizlink.pandora2.server.model.mpi.Valued;

public enum EncodeTypeEnum implements Valued<String>
{
	// Values.
	SHA001("SHA-1"),
	SHA256("SHA-256"),
	SHA384("SHA-384"),
	SHA512("SHA-512");

	// Properties.
	private String value;

	/**
	 */
	private EncodeTypeEnum(String value)
	{
		this.value = value;
	}

	/**
	 */
	@Override
	public final String getValue()
	{
		return value;
	}
}