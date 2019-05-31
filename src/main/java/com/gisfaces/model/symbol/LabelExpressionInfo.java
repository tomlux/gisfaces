package com.gisfaces.model.symbol;

import java.io.Serializable;

/**
 * Label expression info class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-support-LabelClass.html#labelExpressionInfo">ESRI LabelExpressionInfo</a>
 */
public class LabelExpressionInfo implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 7828519283001916814L;

	/** Expression clause. */
	private String expression;

	/**
	 * Constructor.
	 */
	public LabelExpressionInfo()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param expression
	 */
	public LabelExpressionInfo(String expression)
	{
		super();
		this.expression = expression;
	}

	/**
	 * Method to get the expression clause.
	 * @return
	 */
	public String getExpression()
	{
		return expression;
	}

	/**
	 * Method to set the expression clause.
	 * @param expression
	 */
	public void setExpression(String expression)
	{
		this.expression = expression;
	}
}
