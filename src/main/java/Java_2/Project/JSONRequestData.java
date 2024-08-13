package Java_2.Project;

import java.util.ArrayList;

/**
 * The {@code JSONRequestData} class represents a data structure for handling JSON request data.
 * It provides methods to manage the data.
 */
public class JSONRequestData {

	/**
	 * The data contained in the JSON request.
	 */
	ArrayList<String> data;

	/**
	 * Constructs an empty {@code JSONRequestData} object.
	 */
	public JSONRequestData() {
		this.data = new ArrayList<>();
	}

	/**
	 * Returns the data contained in the JSON request.
	 *
	 * @return the data contained in the JSON request
	 */
	public ArrayList<String> getData() {
		return data;
	}

	/**
	 * Sets the data contained in the JSON request.
	 *
	 * @param data the new data to be set
	 */
	public void setData(ArrayList<String> data) {
		this.data = data;
	}

	/**
	 * Adds a line of data to the JSON request.
	 *
	 * @param line the line of data to be added
	 */
	public void addLine(String line) {
		this.data.add(line);
	}
}
