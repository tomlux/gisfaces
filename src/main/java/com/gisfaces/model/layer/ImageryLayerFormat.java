package com.gisfaces.model.layer;

/**
 * Imagery layer format enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-ImageryLayer.html#format">ESRI Imagery Layer Format</a>
 */
public enum ImageryLayerFormat
{
	PNG,
	PNG8,
	PNG24,
	PNG32,
	JPG,
	BMP,
	GIF,
	JPGPNG,
	LERC;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return this.name().toLowerCase();
	}
}
