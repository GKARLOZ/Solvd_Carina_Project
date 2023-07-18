package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.api.GetEmailsMethod;
import com.solvd.qa.carina.demo.api.GetPostsMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.utils.config.Configuration;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.solvd.qa.carina.demo.api.PostUserMethod;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

import static io.restassured.RestAssured.given;

public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    public void testGetEmails() {

        GetEmailsMethod getEmailsMethod = new GetEmailsMethod();
        getEmailsMethod.callAPIExpectSuccess();

    }

    @Test()
    public void testGetAllPosts() {

        GetPostsMethod getPostsMethod = new GetPostsMethod();
        getPostsMethod.callAPIExpectSuccess();
        //getPostsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        //getPostsMethod.validateResponseAgainstSchema("\"api/users/_get/rs2.schema\"");

    }
    @Test()
    public void testCreateUser() throws Exception {

        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");

        api.callAPIExpectSuccess();

        //validation of response
        api.validateResponse();

    }
//    @Test
//    public void randomTest(){
//
//        String baseUrl = "http://graph.facebook.com/v17.0";
//        String endpoint = "/me/posts"; // Replace this with your actual endpoint
//        String accessToken = Configuration.getRequired("api_token");
//        String url = "${base_url}";
//
//
//
//        RestAssured.baseURI = baseUrl;
//
//        Response response = given()
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Bearer " + accessToken)
//                .when()
//                .get(endpoint);
//
//        String responseBody = response.getBody().asString();
//        LOGGER.info(responseBody);
//
////                response.then()
////                .statusCode(200) // Assert the status code is 200
////                .body("id", equalTo(1)) // Example assertion on the response body
////                .body("name", equalTo("doggie")); // Another example assertion on the response bod
//
//
//    }

}
