package com.gisfaces.model.map;

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
