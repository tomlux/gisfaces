package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * KML layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-KMLLayer.html">ESRI KML Layer</a>
 */
public class KMLLayer extends ScaledLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -3052639476450878978L;

	/** Layer URL. */
	private String url;

	/** Portal item. */
	private PortalItem portalItem;

	/**
	 * Constructor.
	 */
	public KMLLayer()
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
}
