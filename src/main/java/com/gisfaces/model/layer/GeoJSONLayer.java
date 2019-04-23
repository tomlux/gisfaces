package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * GeoJSON layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-GeoJSONLayer.html">ESRI Geo JSON Layer</a>
 */
public class GeoJSONLayer extends SubLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 8456952489945269543L;

	/** Layer URL. */
	private String url;

	/** Copyright attribution. */
	private String copyright;

	/**
	 * Constructor.
	 */
	public GeoJSONLayer()
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

	/**
	 * Method to get the copyright attribution.
	 * @return
	 */
	public String getCopyright()
	{
		return copyright;
	}

	/**
	 * Method to set the copyright attribution.
	 * @param copyright
	 */
	public void setCopyright(String copyright)
	{
		this.copyright = copyright;
	}
}
