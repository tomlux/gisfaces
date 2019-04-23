package com.gisfaces.model.symbol;

/**
 * Symbol 3D type enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-Symbol3D.html#type">ESRI Symbol 3D Type</a>
 */
public enum Symbol3DType
{
	POINT_3D,
	LINE_3D,
	POLYGON_3D,
	MESH_3D,
	LABEL_3D;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return this.name().toLowerCase().replaceAll("_", "-");
	}
}
