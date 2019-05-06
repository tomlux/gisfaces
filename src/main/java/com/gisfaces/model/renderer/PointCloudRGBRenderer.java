package com.gisfaces.model.renderer;

import java.io.Serializable;

/**
 * Point cloud RGB renderer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-PointCloudRGBRenderer.html">ESRI PointCloudRGBRenderer</a>
 */
public class PointCloudRGBRenderer extends PointCloudRenderer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 6899446377169873722L;

	/** RGB value field. */
	private String field;

	/* (non-Javadoc)
	 * @see com.gisfaces.model.renderer.Renderer#getType()
	 */
	@Override
	public String getType()
	{
		return PointCloudRendererType.POINT_CLOUD_RGB.toString();
	}

	/**
	 * Method to get the RGB value field.
	 * @return
	 */
	public String getField()
	{
		return field;
	}

	/**
	 * Method to set the RGB value field.
	 * @param field
	 */
	public void setField(String field)
	{
		this.field = field;
	}
}
