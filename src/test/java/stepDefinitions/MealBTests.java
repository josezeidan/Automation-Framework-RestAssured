//package stepDefinitions;
//
//import api.Route;
//import com.jayway.jsonpath.JsonPath;
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Ignore;
//import org.testng.annotations.Test;
//import pojo.Expense;
//
//import static api.MealBApi.*;
//import static utils.ConfigLoader.*;
//import static utils.MealBUtils.*;
//
//public class MealBTests extends TestBase{
//
//    String token;
//
//    @BeforeClass
//    public void setUp(){
//        token = getToken();
//    }
//
//
//
//    @Ignore
//    @Test
//    public void iShouldBeAbleToGetAllExpenses(){
//
//        String url = getQaEnv() + Route.API+Route.GET_EXPENSES;
//
//
//        Response response = submitGetRequest(url,token);
//        response.then().statusCode(200);
//        boolean success = JsonPath.read(response.asPrettyString(),"$.success");
//        Assert.assertTrue(success,"Success field validation failed");
//    }
//
//    @Ignore
//    @Test
//    public void iShouldBeAbletoGetASingleExpense(){
//
//        int id = 9761;
//        String url = getPreprodEnv() + Route.API + Route.GET_EXPENSES + "/" + id;
//        Response response = submitGetRequest(url,token);
//
//        response.then().statusCode(200);
//        boolean success = JsonPath.read(response.asPrettyString(),"$.success");
//        int actualId = JsonPath.read(response.asPrettyString(),"$.result.id");
//
//        Assert.assertEquals(actualId,id,"Id validation Failed");
//
//
//    }
//
//    @Test
//    public void iShouldBeAbleToCreateANExpense(){
//
//        String url = getQaEnv() + Route.API + Route.CREATE_EXPENSE;
//
////        Expense payload = new Expense().
////                              setName("Boston").
////                              setAmount(400.00).
////                              setExpenseDateTime("07/11/2021 00:00:00").
////                              setExpenseType("Travel");
//        Expense payload = expBuilder("New York",600.00, "07/11/2021 00:00:00",
//                "Travel");
//
//
//        Response response = submitPostRequest(url,token,payload);
//
//        response.then().statusCode(200);
//        boolean success = JsonPath.read(response.asPrettyString(),"$.success");
//
//        String actualExpName = JsonPath.read(response.asPrettyString(),"$.result.name");
//        String expectedExpName = payload.getName();
//
//        double actualExpAmount = JsonPath.read(response.asPrettyString(),"$.result.amount");
//        double expectedExpAmount = payload.getAmount();
//
//        int actualId = JsonPath.read(response.asPrettyString(),"$.result.id");
//
//
//        System.out.println("Actual id is: "+actualId);
//
//        Assert.assertTrue(success,"Success field validation failed");
//        Assert.assertEquals(actualExpName,expectedExpName,"Expense name doesn't match");
//        Assert.assertEquals(actualExpAmount,expectedExpAmount,"Expense amount doesn't match");
//
//
//
//    }
//
//
//
//}
