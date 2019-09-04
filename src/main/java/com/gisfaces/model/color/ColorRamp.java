package com.gisfaces.model.color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Color ramp class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ColorRamp implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -522856955208733022L;

	/** From color. */
	private Color fromColor;

	/** To color. */
	private Color toColor;

	/** Number of ramp steps. */
	private int steps;

	/**
	 * Constructor.
	 */
	public ColorRamp()
	{
		this(new Color("#000000"), new Color("#FFFFFF"), 16);
	}

	/**
	 * Constructor.
	 * @param fromColor From color.
	 * @param toColor To color.
	 * @param steps Number of ramp steps.
	 */
	public ColorRamp(Color fromColor, Color toColor, int steps)
	{
		super();
		this.fromColor = fromColor;
		this.toColor = toColor;
		this.steps = steps;
	}

	/**
	 * Method to generate the color ramp.
	 * @return List of <code>Color</code> objects based on the number of steps specified.
	 */
	public List<Color> generateColorRamp()
	{
		List<Color> ramp = new ArrayList<Color>();

		for (int i = 0; i < this.steps; i++)
		{
			// Calculate the ramp step ratio.
			double ratio = (i == 0) ? 0 : ((double) i / (double) (this.steps - 1));

			// Calculate the ramp step RGB values.
			int r = (int) (this.fromColor.getR() + ((this.toColor.getR() - this.fromColor.getR()) * ratio));
			int g = (int) (this.fromColor.getG() + ((this.toColor.getG() - this.fromColor.getG()) * ratio));
			int b = (int) (this.fromColor.getB() + ((this.toColor.getB() - this.fromColor.getB()) * ratio));

			// Calculate the ramp step alpha value.
			double a = (double) (this.fromColor.getA() + ((this.toColor.getA() - this.fromColor.getA()) * ratio));

			// Add the new color to the ramp.
			ramp.add(new Color(r, g, b, a));
		}

		return ramp;
	}

	/**
	 * Method to get the from color.
	 * @return
	 */
	public Color getFromColor()
	{
		return fromColor;
	}

	/**
	 * Method to set the from color.
	 * @param fromColor
	 */
	public void setFromColor(Color fromColor)
	{
		this.fromColor = fromColor;
	}

	/**
	 * Method to get the to color.
	 * @return
	 */
	public Color getToColor()
	{
		return toColor;
	}

	/**
	 * Method to set the to color.
	 * @param toColor
	 */
	public void setToColor(Color toColor)
	{
		this.toColor = toColor;
	}

	/**
	 * Method to get the number of ramp steps.
	 * @return
	 */
	public int getSteps()
	{
		return steps;
	}

	/**
	 * Method to set the number of ramp steps.
	 * @param steps
	 */
	public void setSteps(int steps)
	{
		this.steps = steps;
	}
}
