package serialization;

public class LocationPojo {
	
	//creating POJO for location since it is nested json
	//pass this class to Location variable and methods in MainPojo
	
	private double lat;
	private double lng;
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	

}
