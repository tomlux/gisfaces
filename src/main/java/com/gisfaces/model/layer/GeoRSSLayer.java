package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * GeoRSS layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-GeoRSSLayer.html">ESRI Geo RSS Layer</a>
 */
public class GeoRSSLayer extends ScaledLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -4311471601792519332L;

	/** Layer URL. */
	private String url;

	/**
	 * Constructor.
	 */
	public GeoRSSLayer()
	{
		super();
	}

	/**
	 * Method to get the layer URL.
	 * @return
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Method to set the layer URL.
	 * @param url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
}
