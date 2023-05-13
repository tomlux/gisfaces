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

package com.gisfaces.event;

import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;

/**
 * Map select AJAX behavior event.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class MapSelectEvent extends AjaxBehaviorEvent {
	/** Serial Version UID. */
	private static final long serialVersionUID = 3616025266321207318L;

	/** Layer ID of the selected graphic. */
	private String layerId;

	/** Sublayer ID of the selected graphic. */
	private String subLayerId;

	/** Graphic ID of the selected graphic. */
	private String graphicId;

	/** JSON attribute string of the selected graphic. */
	private String attributesJson;

	/** Map of attributes of the selected graphic. */
	private Map<String, Object> attributesMap;

	/**
	 * Constructor.
	 * 
	 * @param component
	 * @param behavior
	 */
	public MapSelectEvent(UIComponent component, Behavior behavior) {
		super(component, behavior);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.event.AjaxBehaviorEvent#isAppropriateListener(javax.faces.event.
	 * FacesListener)
	 */
	@Override
	public boolean isAppropriateListener(FacesListener listener) {
		return (listener instanceof AjaxBehaviorListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.event.AjaxBehaviorEvent#processListener(javax.faces.event.
	 * FacesListener)
	 */
	@Override
	public void processListener(FacesListener listener) {
		((AjaxBehaviorListener) listener).processAjaxBehavior(this);
	}

	/**
	 * Method to get the layer ID of the selected graphic.
	 * 
	 * @return String
	 */
	public String getLayerId() {
		return layerId;
	}

	/**
	 * Method to set the layer ID of the selected graphic.
	 * 
	 * @param layerId
	 */
	public void setLayerId(String layerId) {
		this.layerId = layerId;
	}

	/**
	 * Method to get the sublayer of the selected graphic.
	 * 
	 * @return
	 */
	public String getSubLayerId() {
		return subLayerId;
	}

	/**
	 * Method to set the sublayer of the selected graphic.
	 * 
	 * @param subLayerId
	 */
	public void setSubLayerId(String subLayerId) {
		this.subLayerId = subLayerId;
	}

	/**
	 * Method to get the graphic ID of the selected graphic.
	 * 
	 * @return
	 */
	public String getGraphicId() {
		return graphicId;
	}

	/**
	 * Method to gset the graphic ID of the selected graphic.
	 * 
	 * @param graphicId
	 */
	public void setGraphicId(String graphicId) {
		this.graphicId = graphicId;
	}

	/**
	 * Method to get the JSON attribute string of the selected graphic.
	 * 
	 * @return String
	 */
	public String getAttributesJson() {
		return attributesJson;
	}

	/**
	 * Method to set the JSON attribute string of the selected graphic.
	 * 
	 * @param attributesJson
	 */
	public void setAttributesJson(String attributesJson) {
		this.attributesJson = attributesJson;
	}

	/**
	 * Method to get the map of attributes of the selected graphic.
	 * 
	 * @return Map
	 */
	public Map<String, Object> getAttributesMap() {
		return attributesMap;
	}

	/**
	 * Method to set the map of attributes of the selected graphic.
	 * 
	 * @param attributesMap
	 */
	public void setAttributesMap(Map<String, Object> attributesMap) {
		this.attributesMap = attributesMap;
	}
}
