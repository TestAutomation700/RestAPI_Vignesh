package deserialization;

import java.util.List;

public class PojoSub {
	
	//declaring WebAutomationPojo, ApiPojo, MobilePojo as List. since it has array of elements
	
	private List<WebAutomationPojo> webAutomation;
	private List<ApiPojo> api;
	private List<MobilePojo> mobile;
	
	
	public List<WebAutomationPojo> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomationPojo> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<ApiPojo> getApi() {
		return api;
	}
	public void setApi(List<ApiPojo> api) {
		this.api = api;
	}
	public List<MobilePojo> getMobile() {
		return mobile;
	}
	public void setMobile(List<MobilePojo> mobile) {
		this.mobile = mobile;
	}

	
	

}
