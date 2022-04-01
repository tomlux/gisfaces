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

package com.gisfaces.component;

import com.gisfaces.model.map.Basemap;
import com.gisfaces.model.map.MapTheme;
import com.gisfaces.model.map.MapDimension;

/**
 * Constants class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public final class Constants {
	public static final String DEFAULT_JSAPI = "https://js.arcgis.com/4.23";
	public static final String DEFAULT_PROXY_PAGE = "/proxy/proxy.jsp";

	public static final MapDimension DEFAULT_DIMENSION = MapDimension.THREE_D;
	public static final Basemap DEFAULT_BASEMAP = Basemap.STREETS_VECTOR;
	public static final MapTheme DEFAULT_THEME = MapTheme.LIGHT;

	public static final double DEFAULT_LATITUDE = 39.828175;
	public static final double DEFAULT_LONGITUDE = -98.5795;
	public static final double DEFAULT_ZOOM = 3.0;

	public static final String ATTRIBUTE_PANEL = "panel";
	public static final String ATTRIBUTE_MODEL = "model";
}
