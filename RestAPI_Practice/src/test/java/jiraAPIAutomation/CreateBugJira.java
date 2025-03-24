package jiraAPIAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

/*
 * Create a Bug using JIRA API
 * Refer JIRA documentation for detailed steps.
 * First we need Authorization key (create API token -> username@exmaple.com:API token ->
 * use any online encoder and paste username@exmaple.com:API token and generate Base64 authorization key
 * use the body availble in documentation
 */

public class CreateBugJira {
	
	@Test
	
	public void createBug() {
		
		RestAssured.baseURI = "https://vigneshviky94.atlassian.net"; //url of Jira project
		
		String bugResponse = given().log().all().header("Content-Type","application/json")
		.header("Authorization","Basic dmlnbmVzaC52aWt5OTRAZ21haWwuY29tOkFUQVRUM3hGZkdGMFBmTFl3X2xUc2JDM1BfRGNYZEY3cEY0NjQ3ckVra2FRcmpYUE9XWW1SVGRhcUl2Vm1zVldoY29sTHd4cXFHeFJQMlMzanJNcmt5MFRkM3NtVjRENUs3WkdSWTVQYjFWa0FGOGN4ZkdrQTFqSk5XQ3ZTbDFZaHAwS196OXd0MGdad3NfM3ctbXR2RVhQWDI4RXN0VFpMRS1aOHJZQlAtSU9NM2o3aUtBY3Nodz03NDAxREVGQw==")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"REST API Bug testing with attachment.\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}")
		.when().post("rest/api/3/issue/")
		.then().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js = new JsonPath(bugResponse);
		String bugID = js.get("id");
		System.out.println(bugID);
		
		// add attachment to a Bug
		//path parameter is used since we dont have any query params
		
		given().log().all().header("X-Atlassian-Token","no-check").pathParam("key", bugID)
		.header("Authorization","Basic dmlnbmVzaC52aWt5OTRAZ21haWwuY29tOkFUQVRUM3hGZkdGMFBmTFl3X2xUc2JDM1BfRGNYZEY3cEY0NjQ3ckVra2FRcmpYUE9XWW1SVGRhcUl2Vm1zVldoY29sTHd4cXFHeFJQMlMzanJNcmt5MFRkM3NtVjRENUs3WkdSWTVQYjFWa0FGOGN4ZkdrQTFqSk5XQ3ZTbDFZaHAwS196OXd0MGdad3NfM3ctbXR2RVhQWDI4RXN0VFpMRS1aOHJZQlAtSU9NM2o3aUtBY3Nodz03NDAxREVGQw==")
		.multiPart("file",new File("C:\\Users\\0035G3744\\Downloads\\ADD-DeletePlaceAPIs.docx"))
		.when().post("rest/api/3/issue/{key}/attachments")
		.then().assertThat().statusCode(200).extract().response();
	}

}
