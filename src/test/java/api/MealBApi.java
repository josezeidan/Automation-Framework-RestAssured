package api;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import pojo.TokenRequestBuilder;
import utils.ConfigLoader;

import static io.restassured.RestAssured.given;
import static utils.ConfigLoader.*;

public class MealBApi {

    public static Response submitTokenRequest(Object payload){

        String url = getQaEnv() + Route.API + Route.TOKEN;

        Response response = given().
                log().all().
                header("Content-Type", "application/json").
                body(payload).
                relaxedHTTPSValidation().
                when().
                post(url).
                then().
                log().all().
                extract().response();

        return response;

    }

    public static String getToken(){

        TokenRequestBuilder tokenRequestBuilder = new TokenRequestBuilder(getCompanyUsername(),getCompanyPassword());

        Response response = submitTokenRequest(tokenRequestBuilder);

        String token = JsonPath.read(response.asPrettyString(),"$.result.accessToken");

        return token;

    }

    public static Response submitGetRequest(String url, String token){

        Response response = given().
                log().all().
                header("Authorization", "Bearer " +token).
                relaxedHTTPSValidation().
                when().
                get(url).
                then().
                log().all().
                extract().
                response();
        return response;
    }

    public static Response submitPostRequest(String url, String token , Object payload){

        Response response = given().
                log().all().
                header("Authorization", "Bearer " +token).
                header("Content-Type", "application/json").
                body(payload).
                relaxedHTTPSValidation().
                when().
                post(url).
                then().
                log().all().
                extract().response();

        return response;
    }



    /*
     * First create a reusable method for post request - submitPostRequest
     * Take three parameters - url, payload, token
     * Create a new constant with endpoint in Route class - create expense
     * Create a pojo class to make a payload
     * Create a test case - iShouldBeAbleToCreateANExpense()
     * Validate status code is - 201
     * */





}
