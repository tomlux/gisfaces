package com.gisfaces.model.symbol;

import java.io.Serializable;

import com.gisfaces.model.color.Color;

/**
 * Simple fill symbol class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-SimpleFillSymbol.html">ESRI SimpleFillSymbol</a>
 */
public class SimpleFillSymbol implements Symbol, Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -7510655312303123025L;

	/** Symbol style. */
	private String style;

	/** Symbol color. */
	private Color color;

	/** Symbol line symbol. */
	private SimpleLineSymbol outline;

	/**
	 * Constructor.
	 */
	public SimpleFillSymbol()
	{
		super();

		this.style = SimpleFillSymbolStyle.SOLID.toString();
		this.color = new Color(128, 128, 128, 0.5d);
		this.outline = new SimpleLineSymbol();
	}

	/**
	 * Constructor.
	 * @param color Color.
	 */
	public SimpleFillSymbol(Color color)
	{
		this();

		this.color = color;
	}

	/* (non-Javadoc)
	 * @see com.gisfaces.symbol.Symbol#getType()
	 */
	@Override
	public String getType()
	{
		return SymbolType.SIMPLE_FILL.toString();
	}

	/**
	 * Method to get the symbol style.
	 * @return
	 */
	public String getStyle()
	{
		return style;
	}

	/**
	 * Method to set the symbol style.
	 * @param style
	 */
	public void setStyle(String style)
	{
		this.style = style;
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
	 * Method to get the symbol line symbol.
	 * @return
	 */
	public SimpleLineSymbol getOutline()
	{
		return outline;
	}

	/**
	 * Method to set the symbol line symbol.
	 * @param outline
	 */
	public void setOutline(SimpleLineSymbol outline)
	{
		this.outline = outline;
	}
}
