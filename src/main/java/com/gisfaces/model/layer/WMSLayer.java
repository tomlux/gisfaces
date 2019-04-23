package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * WMS layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-WMSLayer.html">ESRI WMS Layer</a>
 */
public class WMSLayer extends ScaledLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 3421628046989769343L;

	/** Layer URL. */
	private String url;

	/** Portal item. */
	private PortalItem portalItem;

	/** Refresh interval in minutes. */
	private Double refreshInterval;

	/**
	 * Constructor.
	 */
	public WMSLayer()
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

	/**
	 * Method to get the portal item.
	 * @return
	 */
	public PortalItem getPortalItem()
	{
		return portalItem;
	}

	/**
	 * Method to set the portal item.
	 * @param portalItem
	 */
	public void setPortalItem(PortalItem portalItem)
	{
		this.portalItem = portalItem;
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
