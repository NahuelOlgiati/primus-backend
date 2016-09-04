package com.ebizlink.pandora2.core.util;

import java.io.InputStream;
//import org.apache.commons.lang3.StringUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XppDriver;

public final class XmlUtil
{
	/**
	 */
	@SuppressWarnings("unchecked")
	public static final <T> T fromXML(final InputStream xml, final Class<?>... classList)
	{
		final XStream xstream = new XStream(new XppDriver());

		for (final Class<?> c : classList)
		{
//			xstream.alias(StringUtils.uncapitalize(c.getSimpleName()), c);
		}
		return (T) xstream.fromXML(xml);
	}

	/**
	 */
	public static final <T> String toXML(final T model, final Class<?>... classList)
	{
		final XStream xstream = new XStream(new XppDriver());

		for (final Class<?> c : classList)
		{
//			xstream.alias(StringUtils.uncapitalize(c.getSimpleName()), c);
		}
		return xstream.toXML(model);
	}
}