package com.gisfaces.utilities;

import java.io.IOException;

/**
 * ArcGIS JSON related utilities class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ArcGisJsonUtilities
{
	/**
	 * Constructor.
	 */
	private ArcGisJsonUtilities()
	{
		// Static methods only.
	}

	/**
	 * Method to execute the specified ArcGIS JSON query.
	 * @param url Map service URL.
	 * @return JSON string.
	 * @throws IOException
	 */
	public static final String executeJsonQuery(String url) throws IOException
	{
		return GISUtilities.getUrlConnectionOutput(ArcGisJsonUtilities.buildArcGisUrl(url));
	}

	/**
	 * Method to execute the specified ArcGIS JSON legend query.
	 * @param url Map service URL.
	 * @return JSON string.
	 * @throws IOException
	 */
	public static final String executeJsonLegendQuery(String url) throws IOException
	{
		return GISUtilities.getUrlConnectionOutput(ArcGisJsonUtilities.buildArcGisLegendUrl(url));
	}

	/**
	 * Method to build an ArcGIS query URL.
	 * @param url Map service URL.
	 * @return URL string.
	 */
	public static final String buildArcGisUrl(String url)
	{
		return ArcGisJsonUtilities.stripUrl(url) + "?f=pjson";
	}

	/**
	 * Method to build an ArcGIS legend query URL.
	 * @param url Map service URL.
	 * @return URL string.
	 */
	public static final String buildArcGisLegendUrl(String url)
	{
		return ArcGisJsonUtilities.stripUrl(url) + "/legend?f=pjson";
	}

	/**
	 * Method to strip an URL.
	 * @param url URL.
	 * @return URL without trailing slash and JSON format parameter.
	 */
	public static final String stripUrl(String url)
	{
		return url.replaceAll("/$", "").replaceAll("\\?.*$", "");
	}
}
