package com.gisfaces.model.renderer;

/**
 * Point cloud renderer type enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-PointCloudRenderer.html#type">ESRI Point Cloud Renderer Type</a>
 */
public enum PointCloudRendererType
{
	POINT_CLOUD_CLASS_BREAKS,
	POINT_CLOUD_RGB,
	POINT_CLOUD_STRETCH,
	POINT_CLOUD_UNIQUE_VALUE;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return this.name().toLowerCase().replaceAll("_", "-");
	}
}
