package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Bing maps layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-BingMapsLayer.html">ESRI Bing Maps Layer</a>
 */
public class BingMapsLayer extends ScaledLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -5365901268552030015L;

	/** Bing map key. */
	private String key;

	/** Bing map style. */
	private BingMapsStyle style;

	/** Refresh interval in minutes. */
	private Double refreshInterval;

	/**
	 * Constructor.
	 */
	public BingMapsLayer()
	{
		super();
	}

	/**
	 * Method to get the bing map key.
	 * @return
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * Method to set the bing map key.
	 * @param key
	 */
	public void setKey(String key)
	{
		this.key = key;
	}

	/**
	 * Method to get the bing map style.
	 * @return
	 */
	public BingMapsStyle getStyle()
	{
		return style;
	}

	/**
	 * Method to set the bing map style.
	 * @param style
	 */
	public void setStyle(BingMapsStyle style)
	{
		this.style = style;
	}

	/**
	 * Method to get the refresh interval.
	 * @return
	 */
	public Double getRefreshInterval()
	{
		return refreshInterval;
	}

	/**
	 * Method to set the refresh interval.
	 * @param refreshInterval
	 */
	public void setRefreshInterval(Double refreshInterval)
	{
		this.refreshInterval = refreshInterval;
	}
}
