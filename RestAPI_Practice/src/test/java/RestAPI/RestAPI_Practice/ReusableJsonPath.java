package RestAPI.RestAPI_Practice;

import io.restassured.path.json.JsonPath;

public class ReusableJsonPath {
	
	public static JsonPath rawtoJson (String response) {
		
		JsonPath jp = new JsonPath(response);
		
		return jp;
	}

}
