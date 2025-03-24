package RestApiLibraryAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DataProviderTest {
	
	@Test (dataProvider="BooksData")
	
	//testing Library API - adding books to library
  // change the value of aisle in payload for the test to pass
//passing data from dataprovider method

		public void addBook(String isbn, String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String bookResponse = given().log().all().header("Content-Type","application/json")
		//.body(LibraryAPI.apiRequest()) // this will just add the api request and need to change id in response every time
		 .body(LibraryAPI.apiRequest(isbn,aisle))
		 .when().post("/Library/Addbook.php")
		 .then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(bookResponse);
		
	//get the ID of the book added	
		  JsonPath jp = ReusableMethods.rawToJson(bookResponse); 
		  String id = jp.get("ID");
		  System.out.println(id);
		 
		
		}
	
	@DataProvider(name="BooksData")
		
		public Object[][] getData () {
			
			return new Object[][] {{"cbsbchs","87chs"},{"laksd","891ns"},{"iurq","910la"}};
		}
	}





