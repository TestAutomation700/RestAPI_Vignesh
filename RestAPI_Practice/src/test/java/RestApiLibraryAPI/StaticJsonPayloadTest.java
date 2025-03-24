package RestApiLibraryAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import RestAPI.RestAPI_Practice.ApiPayload;
import io.restassured.RestAssured;

public class StaticJsonPayloadTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//another way of passing request body to automation is giving the json file path
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String placeResponse = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
			.body(GenerateStringFromResource("C:\\Users\\0035G3744\\Desktop\\AddPlace.json"))
			.when().post("maps/api/place/add/json")
			.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
			.header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(placeResponse);
		
	}
	
	public static String GenerateStringFromResource(String path) throws IOException {
      return new String(Files.readAllBytes(Paths.get(path)));



	}

}
