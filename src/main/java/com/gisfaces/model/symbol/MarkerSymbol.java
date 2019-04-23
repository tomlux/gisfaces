package com.gisfaces.model.symbol;

/**
 * Marker symbol class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-MarkerSymbol.html">ESRI MarkerSymbol</a>
 */
public abstract class MarkerSymbol implements Symbol
{
	/** Symbol angle. */
	private int angle;

	/** Symbol X offset. */
	private String xoffset;

	/** Symbol Y offset. */
	private String yoffset;

	/**
	 * Method to get the symbol angle.
	 * @return
	 */
	public int getAngle()
	{
		return angle;
	}

	/**
	 * Method to set the symbol angle.
	 * @param angle
	 */
	public void setAngle(int angle)
	{
		this.angle = angle;
	}

	/**
	 * Method to get the symbol X offset.
	 * @return
	 */
	public String getXoffset()
	{
		return xoffset;
	}

	/**
	 * Method to set the symbol X offset.
	 * @param xoffset
	 */
	public void setXoffset(String xoffset)
	{
		this.xoffset = xoffset;
	}

	/**
	 * Method to get the symbol Y offset.
	 * @return
	 */
	public String getYoffset()
	{
		return yoffset;
	}

	/**
	 * Method to set the symbol Y offset.
	 * @param yoffset
	 */
	public void setYoffset(String yoffset)
	{
		this.yoffset = yoffset;
	}
}
