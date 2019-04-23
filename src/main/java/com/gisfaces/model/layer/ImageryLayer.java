package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Imagery layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-ImageryLayer.html">ESRI Imagery Layer</a>
 */
public class ImageryLayer extends SubLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -8386758702295403695L;

	/** Layer URL. */
	private String url;

	/** Image format type. */
	private String format;

	/** Refresh interval in minutes. */
	private Double refreshInterval;

	/**
	 * Constructor.
	 */
	public ImageryLayer()
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
	 * Method to get the image format type.
	 * @return
	 */
	public String getFormat()
	{
		return format;
	}

	/**
	 * Method to set the image format type.
	 * @param format
	 */
	public void setFormat(String format)
	{
		this.format = format;
	}

	/**
	 * Method to get the refresh interval.
	 * @return
	 */
	public Double getRefreshInterval()
	{
		return refreshInterval;
	}

	/**
	 * Method to set the refresh interval.
	 * @param refreshInterval
	 */
	public void setRefreshInterval(Double refreshInterval)
	{
		this.refreshInterval = refreshInterval;
	}
}
