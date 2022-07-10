package stepdef;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.runner.RunWith;

import Files.Payload;
import Resources.APIResources;
import Resources.TestDataBuild;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import Resources.Utils;

@RunWith(Cucumber.class)
public class Stepdef extends Utils {
  
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data = new TestDataBuild();
    static String place_id;

    @Given("^ADD PLACE PAYLOAD with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_PLACE_PAYLOAD_with(String name, String language, String address) throws Throwable {
	res = given().spec(requestSpecification()).body(data.addPlaceLayout(name, language, address));
	System.out.println(res);
    }

    @When("^User CALLS \"([^\"]*)\", WITH \"([^\"]*)\" HTTP REQUEST$")
    public void user_CALLS_WITH_HTTP_REQUEST(String resource, String method) throws Throwable {
	APIResources resourceAPI = APIResources.valueOf(resource);
	

	resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	if (method.equalsIgnoreCase("POST")) {
	    response = res.when().post(resourceAPI.getResource());

	} else if (method.equalsIgnoreCase("GET")) {
	    response = res.when().get(resourceAPI.getResource());
	}
    }

    @Then("^API CALL IS SUCCESS WITH STATUSCODE (\\d+)$")
    public void api_CALL_IS_SUCCESS_WITH_STATUSCODE(int arg1) throws Throwable {
	System.out.println(response.getStatusCode());
	assertEquals(response.getStatusCode(),200);
    }

    @Then("^\"([^\"]*)\" IN RESPONSE BODY IS \"([^\"]*)\"$")
    public void in_RESPONSE_BODY_IS(String keyValue, String ExpectedVal) throws Throwable {
	assertEquals(getJsonPath(response, keyValue), ExpectedVal);
    }

    @Then("^VERIFUY place_id created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
    public void verifuy_place_id_created_maps_to_using(String expectedName, String resource) throws Throwable {
	place_id=getJsonPath(response, "place_id");
	res=given().spec(requestSpecification()).queryParam("place_id", place_id);
	user_CALLS_WITH_HTTP_REQUEST(resource, "GET");
	String actName=getJsonPath(response, "name");
	assertEquals(actName, expectedName);
    }

}
