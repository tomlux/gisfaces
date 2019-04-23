package com.gisfaces.model.map;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

/**
 * Map theme enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/guide/styling/index.html">ESRI Themes</a>
 */
public enum MapTheme
{
	LIGHT			("light", "Light"),
	DARK			("dark", "Dark"),
	LIGHT_BLUE		("light-blue", "Light Blue"),
	DARK_BLUE		("dark-blue", "Dark Blue"),
	LIGHT_GREEN		("light-green", "Light Green"),
	DARK_GREEN		("dark-green", "Dark Green"),
	LIGHT_PURPLE	("light-purple", "Light Purple"),
	DARK_PURPLE		("dark-purple", "Dark Purple"),
	LIGHT_RED		("light-red", "Light Red"),
	DARK_RED		("dark-red", "Dark Red");

	/** Value. */
	private String value;

	/** title. */
	private String title;

	/**
	 * Constructor.
	 * Package scope required for enum constructors.
	 * @param value Value.
	 * @param title Title.
	 */
	MapTheme(String value, String title)
	{
		this.value = value;
		this.title = title;
	}

	/**
	 * Method to get the enum value.
	 * @return Enum value.
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Method to get the enum title.
	 * @return Enum title.
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Method to get the enum select items.
	 * @return List of SelectItem objects.
	 */
	public static final List<SelectItem> getSelectItems()
	{
		List<SelectItem> items = new ArrayList<SelectItem>();

		for (MapTheme b : MapTheme.values())
		{
			items.add(new SelectItem(b.getValue(), b.getTitle(), b.getTitle()));
		}

		return items;
	}
}
