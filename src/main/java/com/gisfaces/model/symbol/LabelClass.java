/*
 * The MIT License
 *
 * Copyright (c) 2013-2023 Chris Duncan (cduncan@gisfaces.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.gisfaces.model.symbol;

import java.io.Serializable;

/**
 * Label class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-support-LabelClass.html">ESRI
 *      LabelClass</a>
 */
public class LabelClass implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 8596379597376816685L;

	/** Defines the content of label text for MapImageLayer only. */
	private String labelExpression;

	/** Defines the content of label text. */
	private LabelExpressionInfo labelExpressionInfo;

	/** The position of the label. */
	private String labelPlacement;

	/**
	 * The minimum scale (most zoomed out) at which labels are visible in the view.
	 */
	private Integer minScale;

	/**
	 * The maximum scale (most zoomed in) at which labels are visible in the view.
	 */
	private Integer maxScale;

	/** Defines the symbol used for rendering the label. */
	private Symbol symbol;

	/**
	 * Indicates whether to use domain names if the fields in the labelExpression or
	 * labelExpressionInfo have domains.
	 */
	private Boolean useCodedValues;

	/**
	 * A SQL where clause used to determine the features to which the label class
	 * should be applied.
	 */
	private String where;

	/**
	 * Constructor.
	 */
	public LabelClass() {
		super();
	}

	/**
	 * Method to get the label expression.
	 * 
	 * @return
	 */
	public String getLabelExpression() {
		return labelExpression;
	}

	/**
	 * Method to set the label expression.
	 * 
	 * @param labelExpression
	 */
	public void setLabelExpression(String labelExpression) {
		this.labelExpression = labelExpression;
	}

	/**
	 * Method to get the label expression.
	 * 
	 * @return
	 */
	public LabelExpressionInfo getLabelExpressionInfo() {
		return labelExpressionInfo;
	}

	/**
	 * Method to get the label expression.
	 * 
	 * @param labelExpressionInfo
	 */
	public void setLabelExpressionInfo(LabelExpressionInfo labelExpressionInfo) {
		this.labelExpressionInfo = labelExpressionInfo;
	}

	/**
	 * Method to get the label placement.
	 * 
	 * @return
	 */
	public String getLabelPlacement() {
		return labelPlacement;
	}

	/**
	 * Method to set the label placement.
	 * 
	 * @param labelPlacement
	 */
	public void setLabelPlacement(String labelPlacement) {
		this.labelPlacement = labelPlacement;
	}

	/**
	 * Method to get the label minimum scale.
	 * 
	 * @return
	 */
	public Integer getMinScale() {
		return minScale;
	}

	/**
	 * Method to set the label minimum scale.
	 * 
	 * @param minScale
	 */
	public void setMinScale(Integer minScale) {
		this.minScale = minScale;
	}

	/**
	 * Method to get the label maximum scale.
	 * 
	 * @return
	 */
	public Integer getMaxScale() {
		return maxScale;
	}

	/**
	 * Method to set the label maximum scale.
	 * 
	 * @param maxScale
	 */
	public void setMaxScale(Integer maxScale) {
		this.maxScale = maxScale;
	}

	/**
	 * Method to get the label symbol.
	 * 
	 * @return
	 */
	public Symbol getSymbol() {
		return symbol;
	}

	/**
	 * Method to set the label symbol.
	 * 
	 * @param symbol
	 */
	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	/**
	 * Method to get the label use coded values indicator.
	 * 
	 * @return
	 */
	public Boolean getUseCodedValues() {
		return useCodedValues;
	}

	/**
	 * Method to set the label use coded values indicator.
	 * 
	 * @param useCodedValues
	 */
	public void setUseCodedValues(Boolean useCodedValues) {
		this.useCodedValues = useCodedValues;
	}

	/**
	 * Method to get the label where clause.
	 * 
	 * @return
	 */
	public String getWhere() {
		return where;
	}

	/**
	 * Method to set the label where clause.
	 * 
	 * @param where
	 */
	public void setWhere(String where) {
		this.where = where;
	}
}
