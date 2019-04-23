package com.gisfaces.model.symbol;

/**
 * Simple marker symbol style enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-SimpleMarkerSymbol.html#style">ESRI Symbol Style</a>
 */
public enum SimpleMarkerSymbolStyle
{
	CIRCLE,
	CROSS,
	DIAMOND,
	SQUARE,
	TRIANGLE,
	X;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return this.name().toLowerCase();
	}
}
