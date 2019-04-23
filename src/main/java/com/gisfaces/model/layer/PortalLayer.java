package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Generic portal layer class.
 * This class is can be used if the portal layer type is unknown. Otherwise, the specific layer class should be used.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-Layer.html#fromPortalItem">ESRI Portal Item</a>
 */
public class PortalLayer extends Layer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -723154106918890700L;

	/** Portal item. */
	private PortalItem portalItem;

	/**
	 * Constructor.
	 */
	public PortalLayer()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param layerId Layer ID.
	 * @param portalItemId Portal item ID.
	 */
	public PortalLayer(String layerId, String portalItemId)
	{
		super();
		this.setId(layerId);
		this.setPortalItem(new PortalItem(portalItemId));
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
