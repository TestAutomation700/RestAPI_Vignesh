package serialization;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//google map API - available in rahulshettyacademy.com -> practice
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		MainPojo mp = new MainPojo();
		
		LocationPojo l = new LocationPojo();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		mp.setLocation(l);
		mp.setAccuracy(50);
		mp.setName("Frontline house");
		mp.setPhone_number("(+91) 983 893 3937");
		mp.setWebsite("http://google.com");
		mp.setLanguage("French-IN");
	
		//create a list and pass it to set method
		List<String> list = new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		
		mp.setTypes(list);
		
	String response = given().log().all().queryParam("key", "qaclick123")
					.body(mp)
					.when().post("/maps/api/place/add/json")
					.then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(response);
					
	}

}
