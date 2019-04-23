package com.gisfaces.model.layer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Map image layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-MapImageLayer.html">ESRI Map Image Layer</a>
 */
public class MapImageLayer extends ScaledLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 8691288153876461933L;

	/** Layer URL. */
	private String url;

	/** List of sublayers. */
	private List<SubLayer> sublayers;

	/** Refresh interval in minutes. */
	private Double refreshInterval;

	/**
	 * Constructor.
	 */
	public MapImageLayer()
	{
		super();
		this.sublayers = new ArrayList<SubLayer>();
	}

	/**
	 * Constructor.
	 * @param id Layer ID.
	 * @param url Layer URL.
	 */
	public MapImageLayer(String id, String url)
	{
		this();
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
	 * Method to get the list of sublayers.
	 * @return
	 */
	public List<SubLayer> getSublayers()
	{
		return sublayers;
	}

	/**
	 * Method to set the list of sublayers.
	 * @param sublayers
	 */
	public void setSublayers(List<SubLayer> sublayers)
	{
		this.sublayers = sublayers;
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
