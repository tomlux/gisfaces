package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * WMTS sub layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-support-WMTSSublayer.html">ESRI WMTS Sub Layer</a>
 */
public class WMTSSubLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -7978679743314627260L;

	/** Layer ID. */
	private String id;

	/** Layer title. */
	private String title;

	/**
	 * Constructor.
	 */
	public WMTSSubLayer()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param id Layer ID.
	 */
	public WMTSSubLayer(String id)
	{
		super();
		this.id = id;
	}

	/**
	 * Constructor.
	 * @param id Layer ID.
	 * @param title Layer title.
	 */
	public WMTSSubLayer(String id, String title)
	{
		super();
		this.id = id;
		this.title = title;
	}

	/**
	 * Method to get the layer ID.
	 * @return
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Method to set the layer ID.
	 * @param id
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * Method to get the layer title.
	 * @return
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Method to set the layer title.
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
}
