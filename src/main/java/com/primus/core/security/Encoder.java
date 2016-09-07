package com.primus.core.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.primus.core.security.enumeration.EncodeTypeEnum;
import com.thoughtworks.xstream.core.util.Base64Encoder;

public final class Encoder
{
	/**
	 */
	public static final String encode(final EncodeTypeEnum e, final String x) throws NoSuchAlgorithmException
	{
		final MessageDigest md = MessageDigest.getInstance(e.getValue());
		md.reset();
		md.update(x.getBytes());
		return new Base64Encoder().encode(md.digest());
	}
}