package com.gisfaces.model.geometry;

/**
 * Geometry type enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-geometry-Geometry.html#type">ESRI Geometry Type</a>
 */
public enum GeometryType
{
	POINT,
	MULTIPOINT,
	POLYLINE,
	POLYGON,
	EXTENT,
	MESH;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return this.name().toLowerCase();
	}
}
