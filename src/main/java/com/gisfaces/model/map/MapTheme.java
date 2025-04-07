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

import java.util.ArrayList;
import java.util.List;
import jakarta.faces.model.SelectItem;

/**
 * Map theme enum class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/guide/styling/index.html">ESRI
 *      Themes</a>
 */
public enum MapTheme {
	LIGHT("light", "Light"), DARK("dark", "Dark"), LIGHT_BLUE("light-blue", "Light Blue"), DARK_BLUE("dark-blue", "Dark Blue"),
	LIGHT_GREEN("light-green", "Light Green"), DARK_GREEN("dark-green", "Dark Green"), LIGHT_PURPLE("light-purple", "Light Purple"),
	DARK_PURPLE("dark-purple", "Dark Purple"), LIGHT_RED("light-red", "Light Red"), DARK_RED("dark-red", "Dark Red");

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
	MapTheme(String value, String title) {
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
	 * Method to get the enum select items.
	 * 
	 * @return List of SelectItem objects.
	 */
	public static final List<SelectItem> getSelectItems() {
		List<SelectItem> items = new ArrayList<SelectItem>();

		for (MapTheme b : MapTheme.values()) {
			items.add(new SelectItem(b.getValue(), b.getTitle(), b.getTitle()));
		}

		return items;
	}
}
