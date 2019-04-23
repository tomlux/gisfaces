package com.gisfaces.model.symbol;

import java.io.Serializable;

/**
 * Fill symbol 3D layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-FillSymbol3DLayer.html">ESRI Fill Symbol 3D Layer</a>
 */
public class FillSymbol3DLayer extends Symbol3DLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -6553108212186458553L;

	/* (non-Javadoc)
	 * @see com.gisfaces.model.symbol.Symbol3DLayer#getType()
	 */
	@Override
	public String getType()
	{
		return Symbol3DLayerType.FILL.toString();
	}
}
