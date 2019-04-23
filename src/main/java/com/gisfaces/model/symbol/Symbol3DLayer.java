package com.gisfaces.model.symbol;

/**
 * Symbol 3D layer abstract class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-Symbol3DLayer.html">ESRI Symbol 3D Layer</a>
 */
public abstract class Symbol3DLayer
{
	/** Symbol material. */
	private Material material;

	/**
	 * Symbol 3D layer type.
	 * @see Symbol3DLayerType
	 * @return
	 */
	public abstract String getType();

	/**
	 * Method to get the symbol material.
	 * @return
	 */
	public Material getMaterial()
	{
		return material;
	}

	/**
	 * Method to set the symbol material.
	 * @param material
	 */
	public void setMaterial(Material material)
	{
		this.material = material;
	}
}
