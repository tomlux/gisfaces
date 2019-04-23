package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Integrated mesh layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-IntegratedMeshLayer.html">ESRI Integrated Mesh Layer</a>
 */
public class IntegratedMeshLayer extends ScaledLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -626427915063943412L;

	/** Layer URL. */
	private String url;

	/**
	 * Constructor.
	 */
	public IntegratedMeshLayer()
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
