/* Copyright © 2013-2020 Chris Duncan (cduncan@gisfaces.com) - All Rights Reserved */

/**
 * GISFaces geo-location javascript library.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */

// Create the gisfaces namespace.
if (!com) var com = {};
if (!com.gisfaces) com.gisfaces = {};

/**
 * Function to start watching the current geo-location position.
 * @param watch Indicator for continuous geo-location events.
 * @param accuracy Indicator for high accuracy.
 * @param timeout Timeout period in milliseconds for a success.
 * @param maximumAge Maximum age for a cached position. 
 */
com.gisfaces.startWatchCurrentPosition = function(watch, accuracy, timeout, maximumAge) {
	if (navigator.geolocation) {
		// Stop any potential running watches.
		com.gisfaces.stopWatchCurrentPosition();

		console.log("Starting gis geolocation with watch='%s', accuracy='%s', timeout='%s', maximumAge='%s'.", watch, accuracy, timeout, maximumAge);

		// Geolocation options.
		var options = { enableHighAccuracy:accuracy, timeout:timeout, maximumAge:maximumAge };

		if (watch) {
			// Continuous geolocation invocation.
			com.gisfaces.geolocationWatchId = navigator.geolocation.watchPosition(com.gisfaces.processGisGeoLocationEvent, com.gisfaces.processGeoLocationError, options);

			console.log("Geolocation watch ID '%s' created.", com.gisfaces.geolocationWatchId);
		} else {
			// Single geolocation invocation.
			navigator.geolocation.getCurrentPosition(com.gisfaces.processGisGeoLocationEvent, com.gisfaces.processGeoLocationError, options);
		}
	} else {
		alert("Your browser does not support geo-location.");
	}
};

/**
 * Function to stop watching current geolocation position.
 */
com.gisfaces.stopWatchCurrentPosition = function() {
	if (navigator.geolocation) {
		if (com.gisfaces.geolocationWatchId != null) {
			console.log("Stopping geolocation watch ID '%s'.", com.gisfaces.geolocationWatchId);

			// Clear the watch.
			navigator.geolocation.clearWatch(com.gisfaces.geolocationWatchId);

			// Reset the variable.
			com.gisfaces.geolocationWatchId = null;
		}
	}
};

/**
 * Function to process GIS geo-location events.
 * @param position HTML5 GeoLocation Position object.
 */
com.gisfaces.processGisGeoLocationEvent = function(position) {
	console.log("Current gis geolocation timestamp='%s', latitude='%s', longitude='%s'.", position.timestamp, position.coords.latitude, position.coords.longitude);

	// Invoke JSF callback.
	com.gisfaces.generateJsfGisGeoLocationEvent(position);
};

/**
 * Function to process geo-location errors.
 * @param error HTML5 GeoLocation PositionError object.
 */
com.gisfaces.processGeoLocationError = function(error) {
	var message;

	switch(error.code) {
	case error.PERMISSION_DENIED:
		message = "User denied the request for geo-location.";
		break;
	case error.POSITION_UNAVAILABLE:
		message = "Geo-location information is unavailable.";
		break;
	case error.TIMEOUT:
		message = "The request to get user geo-location timed out.";
		break;
	default:
		message = "An unknown geo-location error occurred.";
		break;
	}

	console.log(message);
	alert(message);
};
