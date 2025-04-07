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

import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Widget enum class.
 *
 * @author Tom Schuller (tom@schuller.lu)
 */
public enum Widget {
    CompassWidget("CompassWidget", "2d"),
    BasemapGalleryWidget("BasemapGalleryWidget"),
    CoordinateWidget("CoordinateWidget"),
    DimensionWidget("DimensionWidget"),
    DirectionsWidget("DirectionsWidget"),
    FullscreenWidget("FullscreenWidget"),
    HelpWidget("HelpWidget"),
    LayerListWidget("LayerListWidget"),
    LegendWidget("LegendWidget"),
    MeasurementWidget("MeasurementWidget"),
    PrintWidget("PrintWidget", "2d"),
    ScaleBarWidget("ScaleBarWidget", "2d"),
    SearchWidget("SearchWidget"),
    TrackWidget("TrackWidget");


    /**
     * Value.
     */
    private String value;

    private String type;

    /**
     * Constructor. Package scope required for enum constructors.
     *
     * @param value Value.
     */
    Widget(String value) {
        this.value = value;
        this.type = null;
    }

    /**
     * Constructor. Package scope required for enum constructors.
     *
     * @param value Value.
     * @param type  2d or 3d.
     */
    Widget(String value, String type) {
        this.value = value;
        this.type = type;
    }

    /**
     * Method to get the widget value.
     *
     * @return Widget value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Method to get the widget type.
     *
     * @return Widget type.
     */
    public String getType() {
        return type;
    }
}
