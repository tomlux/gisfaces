package com.gisfaces.model.geometry;

/**
 * Geometry interface.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-geometry-Geometry.html">ESRI Geometry</a>
 */
public interface Geometry
{
	/**
	 * Method to get the geometry type.
	 * @return Geometry type.
	 */
	public String getType();
}
