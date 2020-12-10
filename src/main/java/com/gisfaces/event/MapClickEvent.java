/*
 * The MIT License
 *
 * Copyright (c) 2013-2021 Chris Duncan (cduncan@gisfaces.com)
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

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;

/**
 * Map click AJAX behavior event.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class MapClickEvent extends AjaxBehaviorEvent {
	/** Serial Version UID. */
	private static final long serialVersionUID = 5179890280858855519L;

	/** Map latitude. */
	private double latitude;

	/** Map longitude. */
	private double longitude;

	/**
	 * Constructor.
	 * 
	 * @param component
	 * @param behavior
	 */
	public MapClickEvent(UIComponent component, Behavior behavior) {
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
	 * Method to get the map latitude.
	 * 
	 * @return double
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Method to set the map latitude.
	 * 
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Method to get the map longitude.
	 * 
	 * @return double
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Method to set the map longitude.
	 * 
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
