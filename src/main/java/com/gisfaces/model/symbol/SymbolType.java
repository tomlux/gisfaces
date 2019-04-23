package com.gisfaces.model.symbol;

/**
 * Symbol type enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-Symbol.html#type">ESRI Symbol Type</a>
 */
public enum SymbolType
{
	SIMPLE_MARKER,
	PICTURE_MARKER,
	SIMPLE_LINE,
	CARTOGRAPHIC_LINE_SYMBOL,
	SIMPLE_FILL,
	PICTURE_FILL,
	TEXT,
	SHIELD_LABEL_SYMBOL,
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
