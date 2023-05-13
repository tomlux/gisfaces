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

import com.gisfaces.model.geometry.Extent;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;

/**
 * Map extent AJAX behavior event.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class MapExtentEvent extends AjaxBehaviorEvent {
	/** Serial Version UID. */
	private static final long serialVersionUID = 5264612377050477775L;

	/** Map center latitude. */
	private double latitude;

	/** Map center longitude. */
	private double longitude;

	/** Map zoom level. */
	private double zoom;

	/** Map scale. */
	private double scale;

	/** Map extent. */
	private Extent extent;

	/**
	 * Constructor.
	 * 
	 * @param component
	 * @param behavior
	 */
	public MapExtentEvent(UIComponent component, Behavior behavior) {
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
	 * Method to get the map center latitude.
	 * 
	 * @return double
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Method to set the map center latitude.
	 * 
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Method to get the map center longitude.
	 * 
	 * @return double
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Method to set the map center longitude.
	 * 
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Method to get the map zoom level.
	 * 
	 * @return double
	 */
	public double getZoom() {
		return zoom;
	}

	/**
	 * Method to set the map zoom level.
	 * 
	 * @param zoom
	 */
	public void setZoom(double zoom) {
		this.zoom = zoom;
	}

	/**
	 * Method to get the map scale.
	 * 
	 * @return double
	 */
	public double getScale() {
		return scale;
	}

	/**
	 * Method to set the map scale.
	 * 
	 * @param scale
	 */
	public void setScale(double scale) {
		this.scale = scale;
	}

	/**
	 * Method to get the map extent.
	 * 
	 * @return Extent
	 */
	public Extent getExtent() {
		return extent;
	}

	/**
	 * Method to set the map extent.
	 * 
	 * @param extent
	 */
	public void setExtent(Extent extent) {
		this.extent = extent;
	}
}
