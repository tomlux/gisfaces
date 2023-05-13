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

package com.gisfaces.utilities.json;

/**
 * JSON visitor class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class JSONVisitor {
	/**
	 * Visitor filter interface.
	 * 
	 * @author Chris Duncan (cduncan@gisfaces.com)
	 */
	public interface Filter {
		/**
		 * Method invoked for each JSON key found.
		 * 
		 * @param jo  JSONObject.
		 * @param key JSON key.
		 */
		public void accept(JSONObject jo, String key);
	}

	/** JSON object to process. */
	private JSONObject jo;

	/**
	 * Constructor.
	 * 
	 * @param jo JSONObject.
	 */
	public JSONVisitor(JSONObject jo) {
		super();
		this.jo = jo;
	}

	/**
	 * Method to start visitor processing.
	 * 
	 * @param filter JSONVisitor.Filter.
	 * @throws JSONException
	 */
	public void visit(Filter filter) throws JSONException {
		this.visit(filter, this.jo);
	}

	/**
	 * Method to visit the JSON object nodes.
	 * 
	 * @param filter JSONVisitor.Filter.
	 * @param jo     JSONObject.
	 * @throws JSONException
	 */
	private void visit(Filter filter, JSONObject jo) throws JSONException {
		if (jo != null) {
			// Get the json keys.
			String[] keys = JSONObject.getNames(jo);

			if (keys != null) {
				for (String key : keys) {
					// Get the json key object.
					Object obj = jo.get(key);

					if (obj instanceof JSONObject) {
						this.visit(filter, (JSONObject) obj);
					} else if (obj instanceof JSONArray) {
						this.visit(filter, (JSONArray) obj);
					} else {
						// Invoke the visitor filter.
						filter.accept(jo, key);
					}
				}
			}
		}
	}

	/**
	 * Method to visit the JSON array nodes.
	 * 
	 * @param filter JSONVisitor.Filter.
	 * @param ja     JSONArray.
	 * @throws JSONException
	 */
	private void visit(Filter filter, JSONArray ja) throws JSONException {
		if (ja != null) {
			// Process all array entries.
			for (int i = 0; i < ja.length(); i++) {
				// Get the json array object.
				Object obj = ja.get(i);

				if (obj instanceof JSONObject) {
					this.visit(filter, (JSONObject) obj);
				} else if (obj instanceof JSONArray) {
					this.visit(filter, (JSONArray) obj);
				}
			}
		}
	}
}
