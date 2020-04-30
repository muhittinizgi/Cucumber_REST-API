package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class setUp {
	private static RequestSpecification request;

	String base_uri="https://gorest.co.in/";
	String base_path="public-api/";
	String token="Bearer -1XQUMmbS56iCvgiTC4EurW68d4wn-iDmorx";

	@Given("Set up Base Site and Headers for request")
	public void set_up_site_and_hearders() {
		RestAssured.baseURI =base_uri;
		RestAssured.basePath = base_path;
		request = given().log().all();
		request.contentType(ContentType.JSON);
		request.header("Authorization", token);
	}
	@Then("Tear down the request")
	public void tear_down() {
		RestAssured.reset();
	}

	public static RequestSpecification get_request() {
		return request;
	}
}
		