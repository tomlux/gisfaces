package com.gisfaces.model.map;

import java.io.Serializable;

import com.gisfaces.component.Constants;

/**
 * Map view point class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-Viewpoint.html">ESRI Viewpoint</a>
 */
public class Viewpoint implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 4353555265931757902L;

	/** Map latitude coordinate. */
	private double latitude;

	/** Map longitude coordinate. */
	private double longitude;

	/** Map zoom level. Most ESRI background layers range from 0 to 16 or 23. */
	private double zoom;

	/**
	 * Constructor.
	 */
	public Viewpoint()
	{
		super();
		this.latitude = Constants.DEFAULT_LATITUDE;
		this.longitude = Constants.DEFAULT_LONGITUDE;
		this.zoom = Constants.DEFAULT_ZOOM;
	}

	/**
	 * Method to get the map latitude.
	 * @return
	 */
	public double getLatitude()
	{
		return latitude;
	}

	/**
	 * Method to set the map latitude.
	 * @param latitude
	 */
	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	/**
	 * Method to get the map longitude.
	 * @return
	 */
	public double getLongitude()
	{
		return longitude;
	}

	/**
	 * Method to set the map longitude.
	 * @param longitude
	 */
	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}

	/**
	 * Method to get the map zoom level.
	 * @return
	 */
	public double getZoom()
	{
		return zoom;
	}

	/**
	 * Method to set the map zoom level.
	 * @param zoom
	 */
	public void setZoom(double zoom)
	{
		this.zoom = zoom;
	}
}
