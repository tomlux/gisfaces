package com.gisfaces.model.renderer;

import java.io.Serializable;

/**
 * Color modulation for point cloud renderer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-PointCloudRGBRenderer.html#colorModulation">ESRI ColorModulation</a>
 */
public class ColorModulation implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -9035383193001994181L;

	/** Field to use for the color modulation. Commonly, modulation is used with the intensity field. */
	private String field;

	/** Field value at which the point color becomes darkest. */
	private Integer minValue;

	/** Field value at which the point color will be left unchanged. */
	private Integer maxValue;

	/**
	 * Constructor.
	 */
	public ColorModulation()
	{
		super();
	}

	/**
	 * Method to get the color modulation field.
	 * @return
	 */
	public String getField()
	{
		return field;
	}

	/**
	 * Method to set the color modulation field.
	 * @param field
	 */
	public void setField(String field)
	{
		this.field = field;
	}

	/**
	 * Method to get the minimum value.
	 * @return
	 */
	public Integer getMinValue()
	{
		return minValue;
	}

	/**
	 * Method to set the minimum value.
	 * @param minValue
	 */
	public void setMinValue(Integer minValue)
	{
		this.minValue = minValue;
	}

	/**
	 * Method to get the maximum value.
	 * @return
	 */
	public Integer getMaxValue()
	{
		return maxValue;
	}

	/**
	 * Method to set the maximum value.
	 * @param maxValue
	 */
	public void setMaxValue(Integer maxValue)
	{
		this.maxValue = maxValue;
	}
}
