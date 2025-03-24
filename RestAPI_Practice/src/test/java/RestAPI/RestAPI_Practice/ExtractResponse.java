package RestAPI.RestAPI_Practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class ExtractResponse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* We can remove the whole body given in string in previous example
		 * and pass it from another class file
		 * equalTo() is part of hamcrest and used to validate response
		 * since we use extract method, we can remove log().all() after then()
		 */
		
		//adding a place to a resource by POST method
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(ApiPayload.addPlace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
	
	System.out.println(response);
	
	//parsing the Json response body using Json path class.
	
	JsonPath js = new JsonPath(response);
	String placeID = js.getString("place_id");
	System.out.println(placeID); 
	
	//update the place in a resource using PUT method
	
		String newAddress = "70 winter walk, USA";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeID+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
	//validate the updated address using GET method
	//need to pass 2 query params (which we get in postman)
		
	String getPlaceResponse =	given().log().all().queryParam("key","qaclick123")
		.queryParam("place_id",placeID).when().get("maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath jp = ReusableJsonPath.rawtoJson(getPlaceResponse); //method in ResubaleJsonPath class
	String actualAddress = jp.getString("address");
	System.out.println(actualAddress);
	
	//use Testng assertion to check whether actual and address given are equal
	
	Assert.assertEquals(actualAddress, newAddress);

	}

}
