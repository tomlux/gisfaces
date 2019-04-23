package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * WMTS layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-WMTSLayer.html">ESRI WMTS Layer</a>
 */
public class WMTSLayer extends ScaledLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 4361993346777232903L;

	/** Active sub layer. */
	private WMTSSubLayer activeLayer;

	/** Copyright attribution. */
	private String copyright;

	/** Portal item. */
	private PortalItem portalItem;

	/** Layer URL. */
	private String url;

	/** Refresh interval in minutes. */
	private Double refreshInterval;

	/**
	 * Constructor.
	 */
	public WMTSLayer()
	{
		super();
	}

	/**
	 * Method to get the active sub layer.
	 * @return
	 */
	public WMTSSubLayer getActiveLayer()
	{
		return activeLayer;
	}

	/**
	 * Method to set the active sub layer.
	 * @param activeLayer
	 */
	public void setActiveLayer(WMTSSubLayer activeLayer)
	{
		this.activeLayer = activeLayer;
	}

	/**
	 * Method to get the copyright attribution.
	 * @return
	 */
	public String getCopyright()
	{
		return copyright;
	}

	/**
	 * Method to set the copyright attribution.
	 * @param copyright
	 */
	public void setCopyright(String copyright)
	{
		this.copyright = copyright;
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
