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

package com.gisfaces.component;

import com.gisfaces.utilities.ComponentUtilities;
import com.gisfaces.utilities.StringUtilities;
import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 * GIS SVG symbol.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
@FacesComponent("com.gisfaces.component.Svg")
public class UISvg extends UIOutput {
	/**
	 * Constructor.
	 */
	public UISvg() {
		super();
		setRendererType(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.component.UIComponentBase#encodeBegin(javax.faces.context.
	 * FacesContext)
	 */
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		// Get the response writer.
		ResponseWriter writer = context.getResponseWriter();

		// Get the component client ID.
		String clientId = this.getClientId();

		// Get the component attributes.
		String style = ComponentUtilities.getStringAttribute(this, "style");
		String styleClass = ComponentUtilities.getStringAttribute(this, "styleClass");
		String height = ComponentUtilities.getStringAttribute(this, "height");
		String width = ComponentUtilities.getStringAttribute(this, "width");
		String title = ComponentUtilities.getStringAttribute(this, "title");
		String path = ComponentUtilities.getStringAttribute(this, "path");
		String fillColor = ComponentUtilities.getStringAttribute(this, "fillColor", "#FFFFFF");
		double fillOpacity = ComponentUtilities.getDoubleAttribute(this, "fillOpacity", 1.0d);
		String strokeColor = ComponentUtilities.getStringAttribute(this, "strokeColor", "#000000");
		double strokeOpacity = ComponentUtilities.getDoubleAttribute(this, "strokeOpacity", 1.0d);
		double strokeWidth = ComponentUtilities.getDoubleAttribute(this, "strokeWidth", 1.0d);
		String message = ComponentUtilities.getStringAttribute(this, "message", "SVG not supported.");

		// Begin the svg tag.
		writer.startElement("svg", this);
		writer.writeAttribute("id", clientId, null);
		writer.writeAttribute("style", style, null);
		writer.writeAttribute("styleClass", styleClass, null);
		writer.writeAttribute("height", height, null);
		writer.writeAttribute("width", width, null);

		// Write the title tag.
		if (title != null) {
			writer.startElement("title", this);
			writer.write(StringUtilities.defaultString(title));
			writer.endElement("title");
		}

		// Write the path tag.
		if (path != null) {
			writer.startElement("path", this);
			writer.writeAttribute("d", path, null);
			writer.writeAttribute("fill", fillColor, null);
			writer.writeAttribute("fill-opacity", fillOpacity, null);
			writer.writeAttribute("stroke", strokeColor, null);
			writer.writeAttribute("stroke-opacity", strokeOpacity, null);
			writer.writeAttribute("stroke-width", strokeWidth, null);
			writer.endElement("path");
		}

		// Write the error message.
		writer.write(StringUtilities.defaultString(message));

		// End the svg tag.
		writer.endElement("svg");
	}
}
