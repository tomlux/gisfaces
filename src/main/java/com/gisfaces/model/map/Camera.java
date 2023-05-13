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

package com.gisfaces.model.map;

import com.gisfaces.model.geometry.Point;
import java.io.Serializable;

/**
 * Camera class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-Camera.html">ESRI
 *      Camera</a>
 */
public class Camera implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -5121725683523214883L;

	/** Camera field of view in degrees. */
	private Integer fov;

	/** Camera compass heading in degrees. */
	private Integer heading;

	/** Camera position defined by a map point. */
	private Point position;

	/**
	 * Camera tilt in degrees with respect to the surface as projected down from the
	 * camera position.
	 */
	private Integer tilt;

	/**
	 * Constructor.
	 */
	public Camera() {
		super();
	}

	/**
	 * Method to get the field of view in degrees.
	 * 
	 * @return
	 */
	public Integer getFov() {
		return fov;
	}

	/**
	 * Method to set the field of view in degrees.
	 * 
	 * @param fov
	 */
	public void setFov(Integer fov) {
		this.fov = fov;
	}

	/**
	 * Method to get the heading in degrees.
	 * 
	 * @return
	 */
	public Integer getHeading() {
		return heading;
	}

	/**
	 * Method to set the heading in degrees.
	 * 
	 * @param heading
	 */
	public void setHeading(Integer heading) {
		this.heading = heading;
	}

	/**
	 * Method to get the position.
	 * 
	 * @return
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Method to set the position.
	 * 
	 * @param position
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * Method to get the tilt in degrees.
	 * 
	 * @return
	 */
	public Integer getTilt() {
		return tilt;
	}

	/**
	 * Method to set the tilt in degrees.
	 * 
	 * @param tilt
	 */
	public void setTilt(Integer tilt) {
		this.tilt = tilt;
	}
}
