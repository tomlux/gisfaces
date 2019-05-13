package com.gisfaces.model.layer;

/**
 * Base map layer type enum.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-Layer.html">ESRI Layer</a>
 */
public enum LayerType
{
	CSV,
	FEATURE,
	GEOJSON,
	GEO_RSS,
	GRAPHICS,
	IMAGERY,
	INTEGRATED_MESH,
	KML,
	MAP_IMAGE,
	POINT_CLOUD,
	PORTAL,
	SCENE,
	STREAM,
	TILE,
	VECTOR_TILE,
	WMS,
	WMTS;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return this.name().toLowerCase().replaceAll("_", "-");
	}
}
