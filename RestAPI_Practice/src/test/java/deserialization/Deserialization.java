package deserialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class Deserialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//this array is to check course title with the arraylist at the end
		
		String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};
		
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
				
				PojoMain pm = given()
				.queryParam("access_token", accessToken)
				.when().log().all()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(PojoMain.class);
				
			System.out.println(pm.getInstructor()); //prints instructor
			System.out.println(pm.getLinkedIn()); //prints linkedin link
			
			System.out.println(pm.getCourses().getApi().get(0).getCourseTitle());
			
			List<ApiPojo> apiCourses = pm.getCourses().getApi();
			for(int i=0; i<apiCourses.size();i++) {
				
				if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
					System.out.println(apiCourses.get(i).getPrice());
			}
			
			//Get the course names of WebAutomation
			ArrayList<String> a= new ArrayList<String>();
			
			
			List<WebAutomationPojo> list=pm.getCourses().getWebAutomation();
			
			for(int j=0;j<list.size();j++)
			{
				a.add(list.get(j).getCourseTitle());
			}
			
			List<String> expectedList=	Arrays.asList(courseTitles);
			
			Assert.assertTrue(a.equals(expectedList));
			
			
				
				
	}

}
