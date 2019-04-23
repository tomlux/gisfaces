package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Scene layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-SceneLayer.html">ESRI Scene Layer</a>
 */
public class SceneLayer extends SubLayer implements Serializable
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
	public SceneLayer()
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
