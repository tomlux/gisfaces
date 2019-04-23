package com.gisfaces.model.symbol;

/**
 * Simple fill symbol style enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-SimpleFillSymbol.html#style">ESRI SimpleFillSymbol Style</a>
 */
public enum SimpleFillSymbolStyle
{
	BACKWARD_DIAGONAL,
	CROSS,
	DIAGONAL_CROSS,
	FORWARD_DIAGONAL,
	HORIZONTAL,
	NONE,
	SOLID,
	VERTICAL;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return this.name().toLowerCase().replaceAll("_", "-");
	}
}
