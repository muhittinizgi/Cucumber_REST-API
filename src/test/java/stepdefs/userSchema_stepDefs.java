package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class userSchema_stepDefs {

	private Response response;
	private ValidatableResponse json;
	public RequestSpecification request;

	@When("Go to the webservice to test schema (.+)")
	public void user_hit_the_webservice_to_test(String WebServiceURL){
		request=setUp.get_request();
		response = request.when().get(WebServiceURL);
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("Check schema Status")
	public void verify_status_code(){
		try {
			System.out.println(System.getProperty("user.dir") + "/src/datas/userSchema.json");
			response.then().assertThat().
					body(matchesJsonSchema(
							new File(System.getProperty("user.dir") + "/src/datas/userSchema.json")
					));
			System.out.println("JSON schema validation is OK");
		} catch (Exception e) {
			System.out.println("JSON schema validation NOT OK");
		}
	}
}
		