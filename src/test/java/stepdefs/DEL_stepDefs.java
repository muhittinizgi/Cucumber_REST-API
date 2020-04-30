package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.testng.Assert.assertEquals;

public class DEL_stepDefs {

	private Response response;
	private ValidatableResponse json;
	public RequestSpecification request;

	@When("Go to the webservice to delete (.+)")
	public void user_hit_the_webservice_to_del(String WebServiceURL){
		if (request==null)
			request=setUp.get_request();
//		response = request.when().get(WebServiceURL);
		response = request.delete(WebServiceURL);
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("Check Delete Status code is (\\d+)")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);

		JsonPath js = response.jsonPath();
		System.out.println(js.get("_meta.code"));
		System.out.println(js.get("result"));

		assertEquals(statusCode, response.statusCode());
		assertEquals(statusCode, response.getStatusCode());
	}
}
		