package com.gisfaces.model.geometry;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Geometry polyline class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-geometry-Polyline.html">ESRI Polyline</a>
 */
public class Polyline implements Geometry, Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -4215084863724245402L;

	/** Polyline paths. */
	private Double paths[][][];

	/**
	 * Constructor.
	 */
	public Polyline()
	{
		super();
	}

	/* (non-Javadoc)
	 * @see com.gisfaces.model.geometry.Geometry#getType()
	 */
	@Override
	public String getType()
	{
		return GeometryType.POLYLINE.toString();
	}

	/**
	 * Method to get the polyline paths.
	 * @return
	 */
	public Double[][][] getPaths()
	{
		return paths;
	}

	/**
	 * Method to set the polyline paths.
	 * @param paths
	 */
	public void setPaths(Double[][][] paths)
	{
		this.paths = paths;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return String.format("{type='%s', paths=%s}", this.getType(), Arrays.deepToString(this.paths));
	}
}
