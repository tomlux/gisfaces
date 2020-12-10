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

package com.gisfaces.model.legend;

import java.io.Serializable;

/**
 * Legend layer symbol metadata class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class LegendLayerSymbolMetadata implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -5701008566408792610L;

	/** Symbol label. */
	private String label;

	/** Fully qualified symbol image URL. */
	private String url;

	/** Raw image data. */
	private String imageData;

	/** Symbol image content type. */
	private String contentType;

	/** Symbol image height. */
	private int height;

	/** Symbol image width. */
	private int width;

	/**
	 * Constructor.
	 */
	public LegendLayerSymbolMetadata() {
		super();
	}

	/**
	 * Method to determine if this symbol has an image data URL.
	 * 
	 * @return boolean
	 */
	public boolean isImageDataUrlAvailable() {
		return ((this.imageData != null) && (!"".equals(this.imageData)));
	}

	/**
	 * Method to get the image data URL. This is to be used with
	 * <code>img src</code> instead of the URL to reduce GET requests.
	 * 
	 * @return String
	 */
	public String getImageDataUrl() {
		return String.format("data:%s;base64,%s", this.contentType, this.imageData);
	}

	/**
	 * Method to get the symbol label.
	 * 
	 * @return String
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Method to set the symbol label.
	 * 
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Method to get the fully qualified symbol image URL.
	 * 
	 * @return String
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Method to set the fully qualified symbol image URL.
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Method to get the raw image data.
	 * 
	 * @return String
	 */
	public String getImageData() {
		return imageData;
	}

	/**
	 * Method to set the raw image data.
	 * 
	 * @param imageData
	 */
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	/**
	 * Method to get the symbol image content type.
	 * 
	 * @return String
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * Method to set the symbol image content type.
	 * 
	 * @param contentType
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * Method to get the symbol image height.
	 * 
	 * @return int
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Method to set the symbol image height.
	 * 
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Method to get the symbol image width.
	 * 
	 * @return int
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Method to set the symbol image width.
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
}
