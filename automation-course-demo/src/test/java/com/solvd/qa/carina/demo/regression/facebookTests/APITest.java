package com.solvd.qa.carina.demo.regression.facebookTests;

import com.solvd.qa.carina.demo.facebook.DeletePostMethod;
import com.solvd.qa.carina.demo.facebook.GetPostsMethod;
import com.solvd.qa.carina.demo.facebook.PostMessageMethod;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @TestPriority(Priority.P1)
    public void testCreatePost(){

        PostMessageMethod api = new PostMessageMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();

    }
    @Test()
    @TestPriority(Priority.P2)
    public void testGetLastPosts() {

        GetPostsMethod getPostsMethod = new GetPostsMethod();
        getPostsMethod.callAPIExpectSuccess();
        //getPostsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
       //getPostsMethod.validateResponseAgainstSchema("\"api/users/_get/rs2.schema\"");

    }
    @Test()
    @TestPriority(Priority.P3)
    public void testDeleteLastPost() {
        GetPostsMethod getPostsMethod = new GetPostsMethod();
        Response response = getPostsMethod.callAPIExpectSuccess();
        String id = response.jsonPath().getString("data.id").replaceAll("\\[|\\]","");

        DeletePostMethod deletePostMethod = new DeletePostMethod();
        deletePostMethod.replaceUrlPlaceholder("postId",id);
        deletePostMethod.callAPIExpectSuccess();
        deletePostMethod.validateResponse();
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
