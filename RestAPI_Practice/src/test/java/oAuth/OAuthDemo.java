package oAuth;


import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;

public class OAuthDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//perform POST operation to get the access token		
	String tokenResponse = given()
	.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
	.formParams("grant_type","client_credentials")
	.formParams("scope","trust")
	.when().log().all()
	.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
	
	JsonPath jpath = new JsonPath(tokenResponse);
	String accessToken = jpath.getString("access_token");
	System.out.println(accessToken);
	
	//add access token in the GET request to get course details
	
	String courseDetails = given()
	.queryParam("access_token", accessToken)
	.when().log().all()
	.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
	
	System.out.println(courseDetails);
	
	
	}

}
