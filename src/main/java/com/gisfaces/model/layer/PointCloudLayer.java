package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Point image layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-PointCloudLayer.html">ESRI Point Cloud Layer</a>
 */
public class PointCloudLayer extends Layer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -4413224473086563237L;

	/** Layer URL. */
	private String url;

	/**
	 * Constructor.
	 */
	public PointCloudLayer()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param id Layer ID.
	 * @param url Layer URL.
	 */
	public PointCloudLayer(String id, String url)
	{
		super();
		this.setId(id);
		this.setUrl(url);
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
