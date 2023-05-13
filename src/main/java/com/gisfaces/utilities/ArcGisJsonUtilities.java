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

package com.gisfaces.utilities;

import java.io.IOException;

/**
 * ArcGIS JSON related utilities class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ArcGisJsonUtilities {
	/**
	 * Constructor.
	 */
	private ArcGisJsonUtilities() {
		// Static methods only.
	}

	/**
	 * Method to execute the specified ArcGIS JSON query.
	 * 
	 * @param url Map service URL.
	 * @return JSON string.
	 * @throws IOException
	 */
	public static final String executeJsonQuery(String url) throws IOException {
		return GISUtilities.getUrlConnectionOutput(ArcGisJsonUtilities.buildArcGisUrl(url));
	}

	/**
	 * Method to execute the specified ArcGIS JSON legend query.
	 * 
	 * @param url Map service URL.
	 * @return JSON string.
	 * @throws IOException
	 */
	public static final String executeJsonLegendQuery(String url) throws IOException {
		return GISUtilities.getUrlConnectionOutput(ArcGisJsonUtilities.buildArcGisLegendUrl(url));
	}

	/**
	 * Method to build an ArcGIS query URL.
	 * 
	 * @param url Map service URL.
	 * @return URL string.
	 */
	public static final String buildArcGisUrl(String url) {
		return ArcGisJsonUtilities.stripUrl(url) + "?f=pjson";
	}

	/**
	 * Method to build an ArcGIS legend query URL.
	 * 
	 * @param url Map service URL.
	 * @return URL string.
	 */
	public static final String buildArcGisLegendUrl(String url) {
		return ArcGisJsonUtilities.stripUrl(url) + "/legend?f=pjson";
	}

	/**
	 * Method to strip an URL.
	 * 
	 * @param url URL.
	 * @return URL without trailing slash and JSON format parameter.
	 */
	public static final String stripUrl(String url) {
		return url.replaceAll("/$", "").replaceAll("\\?.*$", "");
	}
}
