package com.gisfaces.model.geometry;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Geometry polygon class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-geometry-Polygon.html">ESRI Polygon</a>
 */
public class Polygon implements Geometry, Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -5299440821893057808L;

	/** Polygon rings. */
	private Double rings[][][];

	/**
	 * Constructor.
	 */
	public Polygon()
	{
		super();
	}

	/* (non-Javadoc)
	 * @see com.gisfaces.model.geometry.Geometry#getType()
	 */
	@Override
	public String getType()
	{
		return GeometryType.POLYGON.toString();
	}

	/**
	 * Method to get the polygon rings.
	 * @return
	 */
	public Double[][][] getRings()
	{
		return rings;
	}

	/**
	 * Method to set the polygon rings.
	 * @param rings
	 */
	public void setRings(Double[][][] rings)
	{
		this.rings = rings;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return String.format("{type='%s', paths=%s}", this.getType(), Arrays.deepToString(this.rings));
	}
}
