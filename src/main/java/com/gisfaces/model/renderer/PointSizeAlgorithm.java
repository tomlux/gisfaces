package com.gisfaces.model.renderer;

/**
 * Point size algorithm interface for point cloud RGB renderer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-PointCloudRGBRenderer.html#pointSizeAlgorithm">ESRI PointSizeAlgorithm</a>
 */
public interface PointSizeAlgorithm
{
	/**
	 * Method to get the point size algorithm type.
	 * @return Renderer type string.
	 */
	public String getType();
}
