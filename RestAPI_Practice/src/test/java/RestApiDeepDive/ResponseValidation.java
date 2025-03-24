package RestApiDeepDive;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ResponseValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath jpath = new JsonPath(NestedResponsePayload.courseResponse());
		
 //get the count of courses		
	int courseCount = jpath.getInt("courses.size()");
	System.out.println(courseCount);
	
 //get the purchase amount
	int purAmount = jpath.getInt("dashboard.purchaseAmount");
	System.out.println(purAmount);
	
 // get the title of first course in the nested array
	String firstTitle = jpath.getString("courses[0].title");
	System.out.println(firstTitle);
	
 // print number of copies sold by RPA.
	
	
	for(int i=0; i<courseCount;i++) {
		
		String courseTitle = jpath.getString("courses["+ i +"].title");
		
		if(courseTitle.equalsIgnoreCase("RPA")) {
			int rpaCopiesCount = jpath.get("courses["+i+"].copies");
			System.out.println(rpaCopiesCount);
			break;
		}
	}
 
// get price of all courses and check their sum is equal to purchase amount
	
	int totalCoursesAmount = 0;
	 for(int i=0; i<courseCount;i++) {
		 totalCoursesAmount = totalCoursesAmount+((jpath.getInt("courses["+ i +"].price"))*(jpath.getInt("courses["+ i +"].copies")));
	 }
	 
	 System.out.println("amount of each course: "+totalCoursesAmount);
	 
	 Assert.assertEquals(totalCoursesAmount, purAmount);
	}

}
