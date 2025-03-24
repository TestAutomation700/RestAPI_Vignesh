package RestApiLibraryAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class TestLibraryAPI {
	
@Test
		
	//testing Library API - adding books to library
  // change the value of aisle in payload for the test to pass

public void addBook() {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String bookResponse = given().log().all().header("Content-Type","application/json")
		//.body(LibraryAPI.apiRequest()) // this will just add the api request and need to change id in response every time
		 .body(LibraryAPI.apiRequest("bcd","6789f"))
		 .when().post("/Library/Addbook.php")
		 .then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(bookResponse);
		
	//get the ID of the book added	
		  JsonPath jp = ReusableMethods.rawToJson(bookResponse); 
		  String id = jp.get("ID");
		  System.out.println(id);
		 
		
		
	}

}
