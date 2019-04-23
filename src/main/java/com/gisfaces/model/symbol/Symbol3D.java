package com.gisfaces.model.symbol;

import java.util.ArrayList;
import java.util.List;

/**
 * Symbol 3D abstract class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-Symbol3D.html">ESRI Symbol 3D</a>
 */
public abstract class Symbol3D implements Symbol
{
	/** List of symbol layers. */
	private List<Symbol3DLayer> symbolLayers = new ArrayList<Symbol3DLayer>();

	/**
	 * Method to get the list of symbol layers.
	 * @return
	 */
	public List<Symbol3DLayer> getSymbolLayers()
	{
		return symbolLayers;
	}

	/**
	 * Method to set the list of symbol layers.
	 * @param symbolLayers
	 */
	public void setSymbolLayers(List<Symbol3DLayer> symbolLayers)
	{
		this.symbolLayers = symbolLayers;
	}
}
