package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Stream layer purge class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-StreamLayer.html#purgeOptions">ESRI Stream Layer Purge Options</a>
 */
public class StreamLayerPurgeOptions implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 102295549820696254L;

	/** The maximum number of features to display. Excess features are purged from the beginning of the graphics array. */
	private Integer displayCount;

	/** The maximum time in minutes that a feature should be kept. After this time, the feature is removed from the layer. */
	private Integer age;

	/**
	 * Constructor.
	 */
	public StreamLayerPurgeOptions()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param displayCount Maximum display count.
	 * @param age Maximum age in minutes.
	 */
	public StreamLayerPurgeOptions(Integer displayCount, Integer age)
	{
		super();
		this.displayCount = displayCount;
		this.age = age;
	}

	/**
	 * Method to get the maximum display count.
	 * @return
	 */
	public Integer getDisplayCount()
	{
		return displayCount;
	}

	/**
	 * Method to set the maximum display count.
	 * @param displayCount
	 */
	public void setDisplayCount(Integer displayCount)
	{
		this.displayCount = displayCount;
	}

	/**
	 * Method to get the maximum age in minutes.
	 * @return
	 */
	public Integer getAge()
	{
		return age;
	}

	/**
	 * Method to set the maximum age in minutes.
	 * @param age
	 */
	public void setAge(Integer age)
	{
		this.age = age;
	}
}
