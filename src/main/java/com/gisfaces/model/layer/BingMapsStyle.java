package com.gisfaces.model.layer;

/**
 * Bing maps style enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-BingMapsLayer.html#style">ESRI Bing Maps Style</a>
 */
public enum BingMapsStyle
{
	ROAD,
	AERIAL,
	HYBRID;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return this.name().toLowerCase();
	}
}
