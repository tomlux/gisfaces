package com.gisfaces.model.symbol;

import java.io.Serializable;

import com.gisfaces.model.color.Color;

/**
 * Simple line symbol class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-LineSymbol.html">ESRI LineSymbol</a>
 */
public class SimpleLineSymbol implements Symbol, Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 6929173323773587094L;

	/** Symbol color. */
	private Color color;

	/** Symbol width. */
	private String width;

	/**
	 * Constructor.
	 */
	public SimpleLineSymbol()
	{
		super();

		this.color = new Color("#000000");
		this.width = "1px";
	}

	/**
	 * Constructor.
	 * @param color Symbol color.
	 * @param width Symbol width.
	 */
	public SimpleLineSymbol(Color color, String width)
	{
		super();

		this.color = color;
		this.width = width;
	}

	/* (non-Javadoc)
	 * @see com.gisfaces.symbol.Symbol#getType()
	 */
	@Override
	public String getType()
	{
		return SymbolType.SIMPLE_LINE.toString();
	}

	/**
	 * Method to get the symbol color.
	 * @return
	 */
	public Color getColor()
	{
		return color;
	}

	/**
	 * Method to set the symbol color.
	 * @param color
	 */
	public void setColor(Color color)
	{
		this.color = color;
	}

	/**
	 * Method to get the symbol width.
	 * @return
	 */
	public String getWidth()
	{
		return width;
	}

	/**
	 * Method to set the symbol width.
	 * @param width
	 */
	public void setWidth(String width)
	{
		this.width = width;
	}
}
