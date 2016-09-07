package com.primus.core.msg.util;

import com.primus.core.msg.MessageHandler;

public final class PM extends MessageHandler
{
	private static PM me;

	/**
	 */
	private PM()
	{
		super("pm");
	}

	/**
	 */
	public static final synchronized PM getMe()
	{
		if (me == null)
		{
			me = new PM();
		}
		return me;
	}
}