package com.gisfaces.utilities.json;

/**
 * JSON visitor class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class JSONVisitor
{
	/**
	 * Visitor filter interface.
	 * @author Chris Duncan (cduncan@gisfaces.com)
	 */
	public interface Filter
	{
		/**
		 * Method invoked for each JSON key found.
		 * @param jo JSONObject.
		 * @param key JSON key.
		 */
		public void accept(JSONObject jo, String key);
	}

	/** JSON object to process. */
	private JSONObject jo;

	/**
	 * Constructor.
	 * @param jo JSONObject.
	 */
	public JSONVisitor(JSONObject jo)
	{
		super();
		this.jo = jo;
	}

	/**
	 * Method to start visitor processing.
	 * @param filter JSONVisitor.Filter.
	 * @throws JSONException
	 */
	public void visit(Filter filter) throws JSONException
	{
		this.visit(filter, this.jo);
	}

	/**
	 * Method to visit the JSON object nodes.
	 * @param filter JSONVisitor.Filter.
	 * @param jo JSONObject.
	 * @throws JSONException
	 */
	private void visit(Filter filter, JSONObject jo) throws JSONException
	{
		if (jo != null)
		{
			// Get the json keys.
			String[] keys = JSONObject.getNames(jo);

			for (String key : keys)
			{
				// Get the json key object.
				Object obj = jo.get(key);

				if (obj instanceof JSONObject)
				{
					this.visit(filter, (JSONObject) obj);
				}
				else if (obj instanceof JSONArray)
				{
					this.visit(filter, (JSONArray) obj);
				}
				else
				{
					// Invoke the visitor filter.
					filter.accept(jo, key);
				}
			}
		}
	}

	/**
	 * Method to visit the JSON array nodes.
	 * @param filter JSONVisitor.Filter.
	 * @param ja JSONArray.
	 * @throws JSONException
	 */
	private void visit(Filter filter, JSONArray ja) throws JSONException
	{
		// Process all array entries.
		for (int i=0; i<ja.length(); i++)
		{
			// Get the json array object.
			Object obj = ja.get(i);

			if (obj instanceof JSONObject)
			{
				this.visit(filter, (JSONObject) obj);
			}
			else if (obj instanceof JSONArray)
			{
				this.visit(filter, (JSONArray) obj); 
			}
		}
	}
}
