package com.gisfaces.model.symbol;

/**
 * Symbol interface.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-Symbol.html">ESRI Symbol</a>
 */
public interface Symbol
{
	/**
	 * Method to get the symbol type.
	 * @see SymbolType
	 * @return Symbol type string.
	 */
	public String getType();
}
