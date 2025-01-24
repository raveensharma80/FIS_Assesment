package TestPack;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class API_Test {

    @Test
    public void verify_response()
    {
        //base URI with Rest Assured class
        RestAssured.baseURI = "https://api.coindesk.com/v1";

        //input details
        RequestSpecification h = RestAssured.given();

        //get response
        Response resp = h.get("/bpi/currentprice.json");

        //Response body
        ResponseBody body = resp.getBody();
        JsonPath jpath = resp.jsonPath();
        Map<String,String> bpi = jpath.getMap("bpi");
        System.out.println(bpi);
        //verify no. of BPI = 3
        Assert.assertEquals(3,bpi.size());
        Assert.assertTrue(bpi.containsKey("USD"));
        Assert.assertTrue(bpi.containsKey("GBP"));
        Assert.assertTrue(bpi.containsKey("EUR"));

        System.out.println("GBP Description = "+jpath.get("bpi.GBP.description"));

        //System.out.println(jpath.get());
    }

}
