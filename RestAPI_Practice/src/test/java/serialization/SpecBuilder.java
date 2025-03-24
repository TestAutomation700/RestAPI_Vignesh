package serialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		//making all the static values like baseURI, query param and header in request in request spec builder
		//all the status code in ResponseSpecification
		
		RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
									.setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();
		
		ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
										   .build();
		
	RequestSpecification response = given().log().all().spec(req)
					.body(mp);
					
			String resStr = response.when().post("/maps/api/place/add/json")
					.then().spec(resSpec).extract().response().asString();
	
	System.out.println(resStr);

	}

}
