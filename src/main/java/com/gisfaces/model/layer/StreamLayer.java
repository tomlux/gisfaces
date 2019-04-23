package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Stream layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-StreamLayer.html">ESRI Stream Layer</a>
 */
public class StreamLayer extends SubLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 6000981135248757493L;

	/** Layer URL. */
	private String url;

	/** Purge options. */
	private StreamLayerPurgeOptions purgeOptions;

	/**
	 * Constructor.
	 */
	public StreamLayer()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param id Layer ID.
	 * @param url Layer URL.
	 */
	public StreamLayer(String id, String url)
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

	/**
	 * Method to get the purge options.
	 * @return
	 */
	public StreamLayerPurgeOptions getPurgeOptions()
	{
		return purgeOptions;
	}

	/**
	 * Method to set the purge options.
	 * @param purgeOptions
	 */
	public void setPurgeOptions(StreamLayerPurgeOptions purgeOptions)
	{
		this.purgeOptions = purgeOptions;
	}
}
