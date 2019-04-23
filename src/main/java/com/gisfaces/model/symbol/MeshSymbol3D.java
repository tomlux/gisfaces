package com.gisfaces.model.symbol;

import java.io.Serializable;

/**
 * Mesh symbol 3D class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-Symbol3D.html">ESRI Mesh Symbol 3D</a>
 */
public class MeshSymbol3D extends Symbol3D implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 4517958463901773058L;

	/* (non-Javadoc)
	 * @see com.gisfaces.model.symbol.Symbol#getType()
	 */
	@Override
	public String getType()
	{
		return Symbol3DType.MESH_3D.toString();
	}
}
