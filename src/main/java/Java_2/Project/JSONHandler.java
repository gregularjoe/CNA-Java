package Java_2.Project;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;

/**
 * The {@code JSONHandler} class provides methods to create and parse JSON objects.
 */
public class JSONHandler {

	/**
	 * Creates a JSON object from the given {@code JSONRequestData}.
	 *
	 * @param data the data to be converted into a JSON object
	 * @return the created JSON object
	 */
	static JSONObject createObject(JSONRequestData data) {
		JSONObject obj = new JSONObject();
		obj.put("data", data.getData());
		return obj;
	}

	/**
	 * Parses a JSON string and converts it into a {@code JSONRequestData} object.
	 *
	 * @param jsonString the JSON string to be parsed
	 * @return the parsed {@code JSONRequestData} object, or {@code null} if parsing fails
	 */
	static JSONRequestData parseObject(String jsonString) {
		JSONParser parser = new JSONParser();

		try {
			JSONObject data = (JSONObject) parser.parse(jsonString);
			JSONRequestData requestData = new JSONRequestData();
			requestData.setData((ArrayList<String>) data.get("data"));
			return requestData;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
