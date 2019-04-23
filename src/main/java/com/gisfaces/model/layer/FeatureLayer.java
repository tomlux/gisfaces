package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Feature layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-FeatureLayer.html">ESRI Feature Layer</a>
 */
public class FeatureLayer extends SubLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 3919100529485904927L;

	/** Layer URL. */
	private String url;

	/** Layer output fields. */
	private String[] outFields;

	/** Refresh interval in minutes. */
	private Double refreshInterval;

	/**
	 * Constructor.
	 */
	public FeatureLayer()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param id Layer ID.
	 * @param url Layer URL.
	 */
	public FeatureLayer(String id, String url)
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
	 * Method to get the layer output fields.
	 * @return
	 */
	public String[] getOutFields()
	{
		return outFields;
	}

	/**
	 * Method to set the layer output fields.
	 * @param outFields
	 */
	public void setOutFields(String[] outFields)
	{
		this.outFields = outFields;
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
