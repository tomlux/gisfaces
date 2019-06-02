package com.gisfaces.model.map;

import java.io.Serializable;

import com.gisfaces.model.geometry.Point;

/**
 * Camera class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-Camera.html">ESRI Camera</a>
 */
public class Camera implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -5121725683523214883L;

	/** Camera field of view in degrees. */
	private Integer fov;

	/** Camera compass heading in degrees. */
	private Integer heading;

	/** Camera position defined by a map point. */
	private Point position;

	/** Camera tilt in degrees with respect to the surface as projected down from the camera position. */
	private Integer tilt;

	/**
	 * Constructor.
	 */
	public Camera()
	{
		super();
	}

	/**
	 * Method to get the field of view in degrees.
	 * @return
	 */
	public Integer getFov()
	{
		return fov;
	}

	/**
	 * Method to set the field of view in degrees.
	 * @param fov
	 */
	public void setFov(Integer fov)
	{
		this.fov = fov;
	}

	/**
	 * Method to get the heading in degrees.
	 * @return
	 */
	public Integer getHeading()
	{
		return heading;
	}

	/**
	 * Method to set the heading in degrees.
	 * @param heading
	 */
	public void setHeading(Integer heading)
	{
		this.heading = heading;
	}

	/**
	 * Method to get the position.
	 * @return
	 */
	public Point getPosition()
	{
		return position;
	}

	/**
	 * Method to set the position.
	 * @param position
	 */
	public void setPosition(Point position)
	{
		this.position = position;
	}

	/**
	 * Method to get the tilt in degrees.
	 * @return
	 */
	public Integer getTilt()
	{
		return tilt;
	}

	/**
	 * Method to set the tilt in degrees.
	 * @param tilt
	 */
	public void setTilt(Integer tilt)
	{
		this.tilt = tilt;
	}
}
