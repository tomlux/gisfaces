package com.gisfaces.model.geometry;

import java.io.Serializable;

/**
 * Spatial reference class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-geometry-SpatialReference.html">ESRI SpatialReference</a>
 */
public class SpatialReference implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -2394864966318913892L;

	/** Default WKID. */
	public static final int WKID_WGS84 = 4326;

	/** Well known ID. */
	private int wkid = SpatialReference.WKID_WGS84;

	/**
	 * Constructor.
	 */
	public SpatialReference()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param wkid Well known ID.
	 */
	public SpatialReference(int wkid)
	{
		super();
		this.wkid = wkid;
	}

	/**
	 * Method to get the wkid.
	 * @return
	 */
	public int getWkid()
	{
		return wkid;
	}

	/**
	 * Method to set the wkid.
	 * @param wkid
	 */
	public void setWkid(int wkid)
	{
		this.wkid = wkid;
	}
}
