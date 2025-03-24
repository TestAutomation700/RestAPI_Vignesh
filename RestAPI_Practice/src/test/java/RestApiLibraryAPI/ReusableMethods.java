package RestApiLibraryAPI;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	public static JsonPath rawToJson (String response) {
		
		JsonPath jpath =  new JsonPath(response);
		return jpath;
	}

}
