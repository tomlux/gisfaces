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

package com.gisfaces.model.map;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 * Map dimennsion enum class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public enum MapDimension {
	TWO_D("2d", "2D"), THREE_D("3d", "3D");

	/** Value. */
	private String value;

	/** title. */
	private String title;

	/**
	 * Constructor. Package scope required for enum constructors.
	 * 
	 * @param value Value.
	 * @param title Title.
	 */
	MapDimension(String value, String title) {
		this.value = value;
		this.title = title;
	}

	/**
	 * Method to get the enum value.
	 * 
	 * @return Enum value.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Method to get the enum title.
	 * 
	 * @return Enum title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Method to get the enum by the specified value.
	 * 
	 * @param value Value
	 * @return MapDimension if found, <code>null</code> otherwise.
	 */
	public static final MapDimension getMapDimensionByValue(String value) {
		for (MapDimension d : MapDimension.values()) {
			if (d.getValue().equalsIgnoreCase(value)) {
				return d;
			}
		}

		return null;
	}

	/**
	 * Method to get the enum select items.
	 * 
	 * @return List of SelectItem objects.
	 */
	public static final List<SelectItem> getSelectItems() {
		List<SelectItem> items = new ArrayList<SelectItem>();

		for (MapDimension d : MapDimension.values()) {
			items.add(new SelectItem(d.getValue(), d.getTitle(), d.getTitle()));
		}

		return items;
	}
}
