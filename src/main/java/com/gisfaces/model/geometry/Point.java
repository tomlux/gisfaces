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

	/** Latitude [-90, 90]. */
	private Double latitude;

	/** Longitude [-180, 180]. */
	private Double longitude;

	/** Altitude in meters. */
	private Double z;

	/** Spatial reference. */
	private SpatialReference spatialReference;

	/**
	 * Constructor.
	 */
	public Point()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param latitude Latitude [-90, 90].
	 * @param longitude Longitude [-180, 180].
	 */
	public Point(Double latitude, Double longitude)
	{
		super();

		this.latitude = latitude;
		this.longitude = longitude;
		this.spatialReference = new SpatialReference(SpatialReference.WKID_WGS84);
	}

	/**
	 * Constructor.
	 * @param latitude Latitude [-90, 90].
	 * @param longitude Longitude [-180, 180].
	 * @param altitude Altitude in meters.
	 */
	public Point(Double latitude, Double longitude, Double altitude)
	{
		super();

		this.latitude = latitude;
		this.longitude = longitude;
		this.z = altitude;
		this.spatialReference = new SpatialReference(SpatialReference.WKID_WGS84);
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
	 * @return Double
	 */
	public Double getLatitude()
	{
		return latitude;
	}

	/**
	 * Method to set the latitude.
	 * @param latitude
	 */
	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	/**
	 * Method to get the longitude.
	 * @return Double
	 */
	public Double getLongitude()
	{
		return longitude;
	}

	/**
	 * Method to set the longitude.
	 * @param longitude
	 */
	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

	/**
	 * Method to get the altitude in meters.
	 * @return
	 */
	public Double getZ()
	{
		return z;
	}

	/**
	 * Method to set the altitude in meters.
	 * @param z
	 */
	public void setZ(Double z)
	{
		this.z = z;
	}

	/**
	 * Method to get the spatial reference.
	 * @return
	 */
	public SpatialReference getSpatialReference()
	{
		return spatialReference;
	}

	/**
	 * Method to set the spatial reference.
	 * @param spatialReference
	 */
	public void setSpatialReference(SpatialReference spatialReference)
	{
		this.spatialReference = spatialReference;
	}

	/**
	 * Method to validate the point values.
	 * @return boolean
	 */
	public boolean isValid()
	{
		return ((this.latitude != null) && (this.latitude <= 90) && (this.latitude >= -90) && (this.longitude != null) && (this.longitude <= 180) && (this.longitude >= -180));
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
