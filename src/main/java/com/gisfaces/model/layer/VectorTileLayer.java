package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Vector tile layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-VectorTileLayer.html">ESRI Vector Tile Layer</a>
 */
public class VectorTileLayer extends ScaledLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 4001558159076457260L;

	/** Layer URL. */
	private String url;

	/**
	 * Constructor.
	 */
	public VectorTileLayer()
	{
		super();
	}

	/**
	 * Method to get the layer URL.
	 * @return
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Method to set the layer URL.
	 * @param url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
}
