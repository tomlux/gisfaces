package com.gisfaces.model.map;

import java.io.Serializable;

/**
 * Web map portal class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class WebMap implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 2131003735305807498L;

	/** Portal item ID. */
	private String portalItemId;

	/**
	 * Constructor.
	 */
	public WebMap()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param portalItemId Portal item ID.
	 */
	public WebMap(String portalItemId)
	{
		super();

		this.portalItemId = portalItemId;
	}

	/**
	 * Method to get the portal item ID.
	 * @return
	 */
	public String getPortalItemId()
	{
		return portalItemId;
	}

	/**
	 * Method to set the portal item ID.
	 * @param portalItemId
	 */
	public void setPortalItemId(String portalItemId)
	{
		this.portalItemId = portalItemId;
	}
}