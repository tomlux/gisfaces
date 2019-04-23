package com.gisfaces.model.renderer;

import java.io.Serializable;

import com.gisfaces.model.symbol.Symbol;

/**
 * Simple renderer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-SimpleRenderer.html">ESRI SimpleRenderer</a>
 */
public class SimpleRenderer implements Renderer, Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 2767804349739248375L;

	/** Renderer symbol. */
	private Symbol symbol;

	/**
	 * Constructor.
	 */
	public SimpleRenderer()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param symbol
	 */
	public SimpleRenderer(Symbol symbol)
	{
		super();

		this.symbol = symbol;
	}

	@Override
	public String getType()
	{
		return RendererType.SIMPLE.toString();
	}

	/**
	 * Method to get the renderer symbol.
	 * @return
	 */
	public Symbol getSymbol()
	{
		return symbol;
	}

	/**
	 * Method to set the renderer symbol.
	 * @param symbol
	 */
	public void setSymbol(Symbol symbol)
	{
		this.symbol = symbol;
	}
}
