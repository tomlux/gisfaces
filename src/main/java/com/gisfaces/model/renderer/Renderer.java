package com.gisfaces.model.renderer;

/**
 * Renderer interface.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-Renderer.html">ESRI Renderer</a>
 */
public interface Renderer
{
	/**
	 * Method to get the renderer type.
	 * @return Renderer type string.
	 */
	public String getType();
}
