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

import com.gisfaces.model.legend.LegendLayerSymbolMetadata;
import com.gisfaces.model.legend.LegendMetadata;
import com.gisfaces.model.legend.LegendMetadataBuilder;
import com.gisfaces.utilities.ComponentUtilities;
import com.gisfaces.utilities.JSFUtilities;
import com.gisfaces.utilities.StringUtilities;
import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 * GIS map symbol custom component using the ESRI ArcGIS JavaScript API.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
@FacesComponent("com.gisfaces.component.MapSymbol")
public class UIMapSymbol extends UIOutput {
	/**
	 * Constructor.
	 */
	public UIMapSymbol() {
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

		// Get the component attributes for the symbol.
		String url = ComponentUtilities.getStringAttribute(this, "url");
		int layer = ComponentUtilities.getIntegerAttribute(this, "layer", 0);
		String label = ComponentUtilities.getStringAttribute(this, "label");

		// Get the legend symbol.
		LegendLayerSymbolMetadata symbol = this.getSymbol(url, layer, label);

		if (symbol != null) {
			// Get the component attributes for the image.
			int height = ComponentUtilities.getIntegerAttribute(this, "height", symbol.getHeight());
			int width = ComponentUtilities.getIntegerAttribute(this, "width", symbol.getWidth());
			String title = ComponentUtilities.getStringAttribute(this, "title", symbol.getLabel());
			String alt = ComponentUtilities.getStringAttribute(this, "alt", symbol.getLabel());

			// Generate the image tag.
			writer.startElement("img", this);
			writer.writeAttribute("id", clientId, null);
			writer.writeAttribute("src", symbol.isImageDataUrlAvailable() ? symbol.getImageDataUrl() : symbol.getUrl(), null);
			writer.writeAttribute("height", height, null);
			writer.writeAttribute("width", width, null);
			writer.writeAttribute("title", StringUtilities.defaultString(title), null);
			writer.writeAttribute("alt", StringUtilities.defaultString(alt), null);
			writer.endElement("img");
		} else {
			// Generate a generic font awesome image.
			writer.startElement("i", this);
			writer.writeAttribute("id", clientId, null);
			writer.writeAttribute("class", "fa fa-picture-o", null);
			writer.endElement("i");
		}
	}

	/**
	 * Method to get a map legend symbol.
	 * 
	 * @param url   Map service URL.
	 * @param layer Layer number, as specified in the map service.
	 * @param label Label name, as specified in the map service legend.
	 * @return LegendLayerSymbolMetadata
	 */
	private LegendLayerSymbolMetadata getSymbol(String url, int layer, String label) {
		LegendLayerSymbolMetadata symbol = null;

		try {
			LegendMetadataBuilder builder = new LegendMetadataBuilder();
			LegendMetadata legend = builder.build(url);
			symbol = legend.findSymbol(layer, label);
		} catch (Throwable t) {
			String summary = String.format("An error occurred retrieving legend metadata for map service '%s'.", url);
			JSFUtilities.addErrorMessage(summary, t.getMessage());
		}

		return symbol;
	}
}
