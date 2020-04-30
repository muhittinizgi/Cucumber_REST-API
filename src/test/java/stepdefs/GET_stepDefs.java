package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.testng.Assert.assertEquals;

public class GET_stepDefs {

	private Response response;
	private ValidatableResponse json;
	public RequestSpecification request;

	@When("Set Parameter page = (.+) for request")
	public void set_parameters_page(String page) {
		request=setUp.get_request();
		request.param("page", page);
//		request.param("first_name", "Wanda");
//		request.param("status", "active");
	}

	@When("Set Parameters (.+) and (.+) to search for request")
	public void set_parameters_fname_lname(String firstname, String lastname) {
		request=setUp.get_request();
		request.param("first_name", firstname);
		request.param("last_name", lastname);
	}

	@Given("Go to the webservice and basepath (.+)")
	public void user_hit_the_webservice(String WebServiceURL){
		if (request==null)
			request=setUp.get_request();
		response = request.when().get(WebServiceURL);
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("Print all the logs on Console")
	public void print_allLogs() {
		response.then().log().all();
	}

	@Then("Check Status code is (\\d+)")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
		System.out.println("-contentType : " + response.contentType());
		System.out.println("-getBody : " + response.getBody());
		System.out.println("-getHeaders : " + response.getHeaders());
		System.out.println("-getStatusCode : " + response.getStatusCode());
		System.out.println("-getStatusLine : " + response.getStatusLine());
		System.out.println("-getTime : " + response.getTime());
		System.out.println("-htmlPath : " + response.htmlPath());

		JsonPath js = response.jsonPath();
		System.out.println(js.get("result"));

		assertEquals(statusCode, response.statusCode());
		assertEquals(statusCode, response.getStatusCode());
	}
}
		