package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;


public class POST_stepDefs {

	private Response response;
	private ValidatableResponse json;
	public RequestSpecification request;

	@When("Set body JSON data to insert new user")
		public void set_body_data(){
		Map<String, Object> userInfo = new HashMap();
		userInfo.put("first_name", "Mark");
		userInfo.put("last_name", "Ritchie");
		userInfo.put("gender", "male");
		userInfo.put("dob", "2005-04-08");
		userInfo.put("email", "MarkRitc@example.net");
		userInfo.put("phone", "111-333-8765");
		userInfo.put("website", "http://www.google.com");
		userInfo.put("address", "111 Terry Suite 805 Margueriteshire, TX 75296-7331");
		userInfo.put("status", "active");
		request=setUp.get_request();
//		request.body(new File(System.getProperty("user.dir") + "/src/datas/newUser.json"));
		request.body(userInfo);
	}


	@When("Go to the webservice to insert: (.+)")
	public void user_hit_the_webservice_to_insert(String WebServiceURL){
		if (request==null)
			request=setUp.get_request();
//		response = request.when().get(WebServiceURL);
		response = request.post(WebServiceURL);
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("Check Insert Status code is (\\d+)")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
		assertEquals(statusCode, response.statusCode());
		assertEquals(statusCode, response.getStatusCode());
	}
}
		