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

package com.gisfaces.model.layer;

import com.gisfaces.model.map.PopupTemplate;
import com.gisfaces.model.renderer.Renderer;
import com.gisfaces.model.symbol.LabelClass;
import java.io.Serializable;

/**
 * Sub layer class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-support-Sublayer.html">ESRI
 *      SubLayer</a>
 */
public class SubLayer extends ScaledLayer implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 408037064384224622L;

	/** Layer URL. */
	private String url;

	/** Layer definition expression. */
	private String definitionExpression;

	/** Labeling information. */
	private LabelClass[] labelingInfo;

	/** Label visibility. */
	private Boolean labelsVisible;

	/** Popup enabled indicator. */
	private boolean popupEnabled = true;

	/** Popup template. */
	private PopupTemplate popupTemplate;

	/** Symbology renderer. */
	private Renderer renderer;

	/**
	 * Constructor.
	 */
	public SubLayer() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param id Layer ID.
	 */
	public SubLayer(String id) {
		this();
		this.setId(id);
	}

	/**
	 * Method to get the layer URL.
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Method to set the layer URL.
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Method to get the layer definition expression.
	 * 
	 * @return
	 */
	public String getDefinitionExpression() {
		return definitionExpression;
	}

	/**
	 * Method to set the layer definition expression.
	 * 
	 * @param definitionExpression
	 */
	public void setDefinitionExpression(String definitionExpression) {
		this.definitionExpression = definitionExpression;
	}

	/**
	 * Method to get the labeling information.
	 * 
	 * @return
	 */
	public LabelClass[] getLabelingInfo() {
		return labelingInfo;
	}

	/**
	 * Method to set the labeling information.
	 * 
	 * @param labelingInfo
	 */
	public void setLabelingInfo(LabelClass[] labelingInfo) {
		this.labelingInfo = labelingInfo;
	}

	/**
	 * Method to get the label visibility.
	 * 
	 * @return
	 */
	public Boolean getLabelsVisible() {
		return labelsVisible;
	}

	/**
	 * Method to set the label visibility.
	 * 
	 * @param labelsVisible
	 */
	public void setLabelsVisible(Boolean labelsVisible) {
		this.labelsVisible = labelsVisible;
	}

	/**
	 * Method to get the popup enabled indicator.
	 * 
	 * @return
	 */
	public boolean isPopupEnabled() {
		return popupEnabled;
	}

	/**
	 * Method to set the popup enabled indicator.
	 * 
	 * @param popupEnabled
	 */
	public void setPopupEnabled(boolean popupEnabled) {
		this.popupEnabled = popupEnabled;
	}

	/**
	 * Method to get the popup template.
	 * 
	 * @return
	 */
	public PopupTemplate getPopupTemplate() {
		return popupTemplate;
	}

	/**
	 * Method to set the popup template.
	 * 
	 * @param popupTemplate
	 */
	public void setPopupTemplate(PopupTemplate popupTemplate) {
		this.popupTemplate = popupTemplate;
	}

	/**
	 * Method to get the symbology renderer.
	 * 
	 * @return
	 */
	public Renderer getRenderer() {
		return renderer;
	}

	/**
	 * Method to set the symbology renderer.
	 * 
	 * @param renderer
	 */
	public void setRenderer(Renderer renderer) {
		this.renderer = renderer;
	}
}
