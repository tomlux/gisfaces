package com.gisfaces.model.geometry;

import java.io.Serializable;

/**
 * Geometry point class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-geometry-Point.html">ESRI Point</a>
 */
public class Point implements Geometry, Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 8606961765098525165L;

	/** Latitude. */
	private double latitude;

	/** Longitude. */
	private double longitude;

	/**
	 * Constructor.
	 */
	public Point()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param latitude
	 * @param longitude
	 */
	public Point(double latitude, double longitude)
	{
		super();

		this.latitude = latitude;
		this.longitude = longitude;
	}

	/* (non-Javadoc)
	 * @see com.gisfaces.model.geometry.Geometry#getType()
	 */
	@Override
	public String getType()
	{
		return GeometryType.POINT.toString();
	}

	/**
	 * Method to get the latitude.
	 * @return double
	 */
	public double getLatitude()
	{
		return latitude;
	}

	/**
	 * Method to set the latitude.
	 * @param latitude
	 */
	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	/**
	 * Method to get the longitude.
	 * @return double
	 */
	public double getLongitude()
	{
		return longitude;
	}

	/**
	 * Method to set the longitude.
	 * @param longitude
	 */
	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}

	/**
	 * Method to validate the point values.
	 * @return boolean
	 */
	public boolean isValid()
	{
		return ((this.latitude <= 90) && (this.latitude >= -90) && (this.longitude <= 180) && (this.longitude >= -180));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return String.format("{type='%s', latitude=%s, longitude=%s}", this.getType(), this.getLatitude(), this.getLongitude());
	}
}
