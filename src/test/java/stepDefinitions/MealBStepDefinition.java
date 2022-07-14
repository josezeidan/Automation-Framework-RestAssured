package stepDefinitions;

import api.Route;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import pojo.TokenRequestBuilder;

import static api.MealBApi.*;
import static utils.ConfigLoader.*;

public class MealBStepDefinition extends TestBase{


    TokenRequestBuilder tokenRequestBuilder;
    Response response;
    String token;
    String env = getQaEnv();;


    @Given("I want to print {string}")
    public void i_want_to_print(String string) {
        System.out.println(string);
    }

    @Given("I create a request payload with username {string} and password {string}")
    public void i_create_a_request_payload_with_username_and_password(String username, String password) {

        tokenRequestBuilder = new TokenRequestBuilder(username,password);

    }
    @When("I submit a POST request to token api")
    public void i_submit_a_post_request_to_token_api() {

         response = submitTokenRequest(tokenRequestBuilder);

    }
    @Then("I validate status code is {int}")
    public void i_validate_status_code_is(Integer statusCode) {

        response.then().statusCode(statusCode);

    }
    @Then("I validate success field is {string}")
    public void i_validate_success_field_is(String success) {

        boolean expectedSuccess = Boolean.parseBoolean(success);
        boolean actualSuccess = JsonPath.read(response.asPrettyString(),"$.success");
        Assert.assertEquals(actualSuccess,expectedSuccess,"dont match");
    }


    @And("I validate error message is {string}")
    public void i_Validate_Error_Message_Is_Message(String message) {

        String actualMessage = JsonPath.read(response.asPrettyString(),"$.error.validationErrors[0].message");
        Assert.assertEquals(actualMessage,message,"Error message");

    }

    @When("I submit a GET request to expense endpoint")
    public void i_submit_a_get_request_to_expense_endpoint() {
        String url = env + Route.API + Route.GET_EXPENSES;
        response = submitGetRequest(url, token);
    }


    @Given("I generate token with {string} account")
    public void iGenerateTokenWithAccount(String accountType) {

        if(accountType.equalsIgnoreCase("walmart")) {
            token = getToken();

        }
    }
}
