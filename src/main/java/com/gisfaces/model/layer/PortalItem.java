package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Portal item class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-portal-PortalItem.html">ESRI Portal Item</a>
 */
public class PortalItem implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -6543761256288872328L;

	/** Portal item ID. */
	private String id;

	/** Portal item title. */
	private String title;

	/**
	 * Constructor.
	 */
	public PortalItem()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param id Portal Item ID.
	 */
	public PortalItem(String id)
	{
		super();
		this.id = id;
	}

	/**
	 * Method to get the portal item ID.
	 * @return
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Method to set the portal item ID.
	 * @param id
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * Method to get the portal item title.
	 * @return
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Method to set the portal item title.
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
}
