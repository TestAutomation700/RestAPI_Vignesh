package deserialization;


public class PojoMain {
		
		/*using oAuth response example for Deserialization
		 * constructing pojo(getters and setters) for all the main objects in response
		 */
		
	    private String instructor;
		private String url;
		private String services;
		private String expertise;
		private PojoSub courses; //since courses has sub objects and return type should be of that type
		private String linkedIn;
		
		
		public String getInstructor() {
			return instructor;
		}
		public void setInstructor(String instructor) {
			this.instructor = instructor;
		}
		
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getServices() {
			return services;
		}
		public void setServices(String services) {
			this.services = services;
		}
		public String getExpertise() {
			return expertise;
		}
		public void setExpertise(String expertise) {
			this.expertise = expertise;
		}
		public PojoSub getCourses() {
			return courses;
		}
		public void setCourses(PojoSub courses) {
			this.courses = courses;
		}
		public String getLinkedIn() {
			return linkedIn;
		}
		public void setLinkedIn(String linkedIn) {
			this.linkedIn = linkedIn;
		}


}
