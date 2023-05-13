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

package com.gisfaces.model.geometry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Geometry extent class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-geometry-Extent.html">ESRI
 *      Extent</a>
 */
public class Extent implements Geometry, Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -6871113138424134930L;

	/** Extent bottom-left X-point (longitude). */
	private double xmin;

	/** Extent bottom-left Y-point (latitude). */
	private double ymin;

	/** Extent top-right X-point (longitude). */
	private double xmax;

	/** Extent top-right Y-point (latitude). */
	private double ymax;

	/** Spatial reference. */
	private SpatialReference spatialReference;

	/**
	 * Constructor.
	 */
	public Extent() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param p Point.
	 */
	public Extent(Point p) {
		this(p, p);
	}

	/**
	 * Constructor.
	 * 
	 * @param p1 Bottom-left point.
	 * @param p2 Top-right point.
	 */
	public Extent(Point p1, Point p2) {
		this(p1.getLongitude(), p1.getLatitude(), p2.getLongitude(), p2.getLatitude());
	}

	/**
	 * Constructor.
	 * 
	 * @param xmin Extent bottom-left X-point.
	 * @param ymin Extent bottom-left Y-point.
	 * @param xmax Extent top-right X-point.
	 * @param ymax Extent top-right Y-point.
	 */
	public Extent(double xmin, double ymin, double xmax, double ymax) {
		this(SpatialReference.WKID_WGS84, xmin, ymin, xmax, ymax);
	}

	/**
	 * Constructor.
	 * 
	 * @param wkid Spatial reference well-known ID.
	 * @param xmin Extent bottom-left X-point.
	 * @param ymin Extent bottom-left Y-point.
	 * @param xmax Extent top-right X-point.
	 * @param ymax Extent top-right Y-point.
	 */
	public Extent(int wkid, double xmin, double ymin, double xmax, double ymax) {
		super();
		this.xmin = xmin;
		this.ymin = ymin;
		this.xmax = xmax;
		this.ymax = ymax;
		this.spatialReference = new SpatialReference(wkid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gisfaces.model.geometry.Geometry#getType()
	 */
	@Override
	public String getType() {
		return GeometryType.EXTENT.toString();
	}

	/**
	 * Method to get the extent bottom-left X-point.
	 * 
	 * @return double
	 */
	public double getXmin() {
		return xmin;
	}

	/**
	 * Method to set the extent bottom-left X-point.
	 * 
	 * @param xmin
	 */
	public void setXmin(double xmin) {
		this.xmin = xmin;
	}

	/**
	 * Method to get the extent bottom-left Y-point.
	 * 
	 * @return double
	 */
	public double getYmin() {
		return ymin;
	}

	/**
	 * Method to set the extent bottom-left Y-point.
	 * 
	 * @param ymin
	 */
	public void setYmin(double ymin) {
		this.ymin = ymin;
	}

	/**
	 * Method to get the extent top-right X-point.
	 * 
	 * @return double
	 */
	public double getXmax() {
		return xmax;
	}

	/**
	 * Method to set the extent top-right X-point.
	 * 
	 * @param xmax
	 */
	public void setXmax(double xmax) {
		this.xmax = xmax;
	}

	/**
	 * Method to get the extent top-right Y-point.
	 * 
	 * @return double
	 */
	public double getYmax() {
		return ymax;
	}

	/**
	 * Method to set the extent top-right Y-point.
	 * 
	 * @param ymax
	 */
	public void setYmax(double ymax) {
		this.ymax = ymax;
	}

	/**
	 * Method to get the spatial reference.
	 * 
	 * @return
	 */
	public SpatialReference getSpatialReference() {
		return spatialReference;
	}

	/**
	 * Method to set the spatial reference.
	 * 
	 * @param spatialReference
	 */
	public void setSpatialReference(SpatialReference spatialReference) {
		this.spatialReference = spatialReference;
	}

	/**
	 * Method to get the extent points.
	 * 
	 * @return List
	 */
	public List<Point> getPoints() {
		List<Point> points = null;

		if ((this.xmin != 0) && (this.ymin != 0) && (this.xmax != 0) && (this.ymax != 0)) {
			points = new ArrayList<Point>();

			points.add(new Point(ymin, xmin));
			points.add(new Point(ymax, xmax));
		}

		return points;
	}

	/**
	 * Method to get the center point.
	 * 
	 * @return Point
	 */
	public Point getCenter() {
		double x = (this.xmin + this.xmax) / 2;
		double y = (this.ymin + this.ymax) / 2;

		return new Point(y, x);
	}

	/**
	 * Method to get width.
	 * 
	 * @return double
	 */
	public double getWidth() {
		return Math.abs(this.xmax - this.xmin);
	}

	/**
	 * Method to get the height.
	 * 
	 * @return double
	 */
	public double getHeight() {
		return Math.abs(this.ymax - this.ymin);
	}

	/**
	 * Method to scale the extent.
	 * 
	 * @param factor Multiplication factor.
	 */
	public void scale(double factor) {
		double df = (1 - factor) / 2;

		double dx = this.getWidth() * df;
		double dy = this.getHeight() * df;

		this.xmin += dx;
		this.ymin += dy;
		this.xmax -= dx;
		this.ymax -= dy;
	}

	/**
	 * Method to calculate the union of a set of points.
	 * 
	 * @param points List of Point objects.
	 * @return Extent bounding all specified points.
	 */
	public static final Extent union(List<Point> points) {
		Extent e = null;

		if ((points != null) && (!points.isEmpty())) {
			e = new Extent(points.get(0));

			for (Point c : points) {
				if (c.getLatitude() < e.getYmin())
					e.setYmin(c.getLatitude());
				if (c.getLatitude() > e.getYmax())
					e.setYmax(c.getLatitude());
				if (c.getLongitude() < e.getXmin())
					e.setXmin(c.getLongitude());
				if (c.getLongitude() > e.getXmax())
					e.setXmax(c.getLongitude());
			}
		}

		return e;
	}

	/**
	 * Method to calculate the union of the extents.
	 * 
	 * @param e1 Extent.
	 * @param e2 Extent.
	 * @return Extent bounding all specified points.
	 */
	public static final Extent union(Extent e1, Extent e2) {
		Extent e = null;

		List<Point> points = new ArrayList<Point>();

		// Get the points from the first extent.
		if ((e1 != null) && (e1.getPoints() != null)) {
			points.addAll(e1.getPoints());
		}

		// Get the points from the second extent.
		if ((e2 != null) && (e2.getPoints() != null)) {
			points.addAll(e2.getPoints());
		}

		// Build the extent.
		if (!points.isEmpty()) {
			e = Extent.union(points);
		}

		return e;
	}
}
