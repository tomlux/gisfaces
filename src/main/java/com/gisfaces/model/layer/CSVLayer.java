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

package com.gisfaces.model.layer;

import com.gisfaces.model.renderer.SimpleRenderer;
import com.gisfaces.model.symbol.SimpleMarkerSymbol;
import java.io.Serializable;

/**
 * CSV layer class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-CSVLayer.html">ESRI
 *      CSV Layer</a>
 */
public class CSVLayer extends SubLayer implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -3910079538216956931L;

	/** Layer URL. */
	private String url;

	/** Copyright attribution. */
	private String copyright;

	/** Column delimiter. */
	private String delimiter;

	/** Latitude field name. */
	private String latitudeField;

	/** Longitude field name. */
	private String longitudeField;

	/** Layer output fields. */
	private String[] outFields;

	/**
	 * Constructor.
	 */
	public CSVLayer() {
		super();

		// Renderer is required for this layer type.
		this.setRenderer(new SimpleRenderer(new SimpleMarkerSymbol()));
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
	 * Method to get the copyright attribution.
	 * 
	 * @return
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * Method to set the copyright attribution.
	 * 
	 * @param copyright
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	/**
	 * Method to get the column delimiter.
	 * 
	 * @return
	 */
	public String getDelimiter() {
		return delimiter;
	}

	/**
	 * Method to set the column delimiter.
	 * 
	 * @param delimiter
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * Method to get the latitude field name.
	 * 
	 * @return
	 */
	public String getLatitudeField() {
		return latitudeField;
	}

	/**
	 * Method to set the latitude field name.
	 * 
	 * @param latitudeField
	 */
	public void setLatitudeField(String latitudeField) {
		this.latitudeField = latitudeField;
	}

	/**
	 * Method to get the longitude field name.
	 * 
	 * @return
	 */
	public String getLongitudeField() {
		return longitudeField;
	}

	/**
	 * Method to set the longitude field name.
	 * 
	 * @param longitudeField
	 */
	public void setLongitudeField(String longitudeField) {
		this.longitudeField = longitudeField;
	}

	/**
	 * Method to get the layer output fields.
	 * 
	 * @return
	 */
	public String[] getOutFields() {
		return outFields;
	}

	/**
	 * Method to set the layer output fields.
	 * 
	 * @param outFields
	 */
	public void setOutFields(String[] outFields) {
		this.outFields = outFields;
	}
}
