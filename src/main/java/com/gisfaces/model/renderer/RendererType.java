package com.gisfaces.model.renderer;

/**
 * Renderer type enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-Renderer.html#type">ESRI Renderer Type</a>
 */
public enum RendererType
{
	CLASS_BREAKS,
	HEATMAP,
	SIMPLE,
	UNIQUE_VALUE;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return this.name().toLowerCase().replaceAll("_", "-");
	}
}
