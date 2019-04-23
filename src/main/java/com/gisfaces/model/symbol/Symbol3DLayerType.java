package com.gisfaces.model.symbol;

/**
 * Symbol 3D layer type enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-Symbol3DLayer.html#type">ESRI Symbol 3D Layer Type</a>
 */
public enum Symbol3DLayerType
{
	ICON,
	OBJECT,
	LINE,
	PATH,
	FILL,
	EXTRUSION,
	TEXT;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return this.name().toLowerCase();
	}
}
