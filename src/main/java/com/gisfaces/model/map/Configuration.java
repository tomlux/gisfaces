package com.gisfaces.model.map;

import java.io.Serializable;

import com.gisfaces.component.Constants;

/**
 * Map configuration class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class Configuration implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 4106942894342098444L;

	/** Esri JavaScript API URL. */
	private String jsApiUrl = Constants.DEFAULT_JSAPI;

	/** Local geometry service URL. */
	private String geometryServiceUrl;

	/** Local geoRSS service URL. */
	private String geoRssServiceUrl;

	/** Local KML service URL. */
	private String kmlServiceUrl;

	/** Local portal URL. */
	private String portalUrl;

	/** Local proxy URL to override included proxy. */
	private String proxyUrl;

	/** Proxy enabled indicator. Included proxy used by default. */
	private boolean proxyEnabled;

	/**
	 * Constructor.
	 */
	public Configuration()
	{
		super();
	}

	/**
	 * Method to get the ESRI JavaScript API URL.
	 * @return
	 */
	public String getJsApiUrl()
	{
		return jsApiUrl;
	}

	/**
	 * Method to set the ESRI JavaScript API URL.
	 * @param jsApiUrl
	 */
	public void setJsApiUrl(String jsApiUrl)
	{
		this.jsApiUrl = jsApiUrl;
	}

	/**
	 * Method to get the local geometry service URL.
	 * @return
	 */
	public String getGeometryServiceUrl()
	{
		return geometryServiceUrl;
	}

	/**
	 * Method to set the local geometry service URL.
	 * @param geometryServiceUrl
	 */
	public void setGeometryServiceUrl(String geometryServiceUrl)
	{
		this.geometryServiceUrl = geometryServiceUrl;
	}

	/**
	 * Method to get the local geoRSS service URL.
	 * @return
	 */
	public String getGeoRssServiceUrl()
	{
		return geoRssServiceUrl;
	}

	/**
	 * Method to set the local geoRSS service URL.
	 * @param geoRssServiceUrl
	 */
	public void setGeoRssServiceUrl(String geoRssServiceUrl)
	{
		this.geoRssServiceUrl = geoRssServiceUrl;
	}

	/**
	 * Method to get the local KML service URL.
	 * @return
	 */
	public String getKmlServiceUrl()
	{
		return kmlServiceUrl;
	}

	/**
	 * Method to set the local KML service URL.
	 * @param kmlServiceUrl
	 */
	public void setKmlServiceUrl(String kmlServiceUrl)
	{
		this.kmlServiceUrl = kmlServiceUrl;
	}

	/**
	 * Method to get the local portal URL.
	 * @return
	 */
	public String getPortalUrl()
	{
		return portalUrl;
	}

	/**
	 * Method to set the local portal URL.
	 * @param portalUrl
	 */
	public void setPortalUrl(String portalUrl)
	{
		this.portalUrl = portalUrl;
	}

	/**
	 * Method to get the local proxy URL.
	 * @return
	 */
	public String getProxyUrl()
	{
		return proxyUrl;
	}

	/**
	 * Method to set the local proxy URL.
	 * @param proxyUrl
	 */
	public void setProxyUrl(String proxyUrl)
	{
		this.proxyUrl = proxyUrl;
	}

	/**
	 * Method to get the proxy enabled indicator.
	 * @return
	 */
	public boolean isProxyEnabled()
	{
		return proxyEnabled;
	}

	/**
	 * Method to set the proxy enabled indicator.
	 * @param proxyEnabled
	 */
	public void setProxyEnabled(boolean proxyEnabled)
	{
		this.proxyEnabled = proxyEnabled;
	}
}
