package com.gisfaces.model.layer;

/**
 * Scaled layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public abstract class ScaledLayer extends Layer
{
	/** Minimum map scale for layer visibility. */
	private Integer minScale;

	/** Maximum map scale for layer visibility. */	
	private Integer maxScale;

	/**
	 * Method to get the minimum map scale for layer visibility.
	 * @return
	 */
	public Integer getMinScale()
	{
		return minScale;
	}

	/**
	 * Method to set the minimum map scale for layer visibility.
	 * @param minScale
	 */
	public void setMinScale(Integer minScale)
	{
		this.minScale = minScale;
	}

	/**
	 * Method to get the maximum map scale for layer visibility.
	 * @return
	 */
	public Integer getMaxScale()
	{
		return maxScale;
	}

	/**
	 * Method to set the maximum map scale for layer visibility.
	 * @param maxScale
	 */
	public void setMaxScale(Integer maxScale)
	{
		this.maxScale = maxScale;
	}
}
