package com.gisfaces.utilities;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.gisfaces.utilities.json.JSONException;
import com.gisfaces.utilities.json.JSONObject;

/**
 * String related utilities.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class StringUtilities
{
	/**
	 * Constructor.
	 */
	private StringUtilities()
	{
		// Class contains static methods only.
	}

	/**
	 * Method to convert a JSON string to a map.
	 * @param json JSON formatted string.
	 * @return Map.
	 */
	public static final Map<String, Object> toMap(String json)
	{
		Map<String, Object> map = null;

		try
		{
			JSONObject jo = new JSONObject(json);

			@SuppressWarnings("rawtypes")
			Iterator iter = jo.keys();
			if (iter.hasNext())
			{
				map = new HashMap<String, Object>();

				while (iter.hasNext())
				{
					String key = (String) iter.next();
					Object value = jo.get(key);

					map.put(key, value);
				}
			}
		}
		catch (JSONException e)
		{
			// Do nothing.
		}

		return map;
	}

	/**
	 * Method to convert a map to JSON format.
	 * @param map Map.
	 * @return JSON formatted string.
	 */
	public static final String toJson(Map<String, Object> map)
	{
		return new JSONObject(map).toString();
	}

	/**
	 * Method to join an iteration of strings.
	 * @param iter Iterator of strings.
	 * @param delimiter Delimiter
	 * @return Concatenated string.
	 */
	public static final String join(Iterator<String> iter, String delimiter)
	{
		StringBuffer sb = new StringBuffer();

		if (iter != null)
		{
			while (iter.hasNext())
			{
				if (sb.length() != 0)
				{
					sb.append(delimiter);
				}

				sb.append(iter.next());
			}
		}

		return sb.toString();
	}

	/**
	 * Method to validate the specified string is not null.
	 * @param s String.
	 * @return The specified string, if not null, otherwise, an empty string.
	 */
	public static final String defaultString(String s)
	{
		return ((s != null) ? s : "");
	}

	/**
	 * Method to validate the specified string is not null.
	 * @param s String.
	 * @param def Default string.
	 * @return The specified string, if not null, otherwise, the default string.
	 */
	public static final String defaultString(String s, String def)
	{
		return ((s != null) ? s : def);
	}

	/**
	 * Method to provide null safe toString functionality.
	 * @param o Object
	 * @return The string representation of the object.
	 */
	public static final String toString(Object o)
	{
		return ((o != null) ? o.toString() : "");
	}

	/**
	 * Method to encode string.
	 * Note: Must be compatible with JavaScript <code>escape()</code> and <code>unescape()</code> functions.
	 * @param s String to encode.
	 * @return Encoded string.
	 */
	public static final String encode(String s)
	{
		try
		{
			return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
		}
		catch (Exception e)
		{
			return s;
		}
	}

	/**
	 * Method to decode string.
	 * Note: Must be compatible with JavaScript <code>escape()</code> and <code>unescape()</code> functions.
	 * @param s String to decode.
	 * @return Decoded string.
	 */
	public static final String decode(String s)
	{
		try
		{
			return URLDecoder.decode(s.replaceAll("\\%20", "+"), "UTF-8");
		}
		catch (Exception e)
		{
			return s;
		}
	}
}
