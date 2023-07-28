package com.solvd.qa.carina.solvd_test;

import com.solvd.qa.carina.solvd_files.facebook.DeletePostMethod;
import com.solvd.qa.carina.solvd_files.facebook.GetPostsMethod;
import com.solvd.qa.carina.solvd_files.facebook.PostMessageMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    public void testCreatePost(){

        PostMessageMethod api = new PostMessageMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();

    }
    @Test()
    public void testGetLastPosts() {

        GetPostsMethod getPostsMethod = new GetPostsMethod();
        getPostsMethod.callAPIExpectSuccess();
        getPostsMethod.validateResponse(JSONCompareMode.STRICT_ORDER, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
       getPostsMethod.validateResponseAgainstSchema("facebookresources/message/_get/rs2.schema");

    }
    @Test()
    public void testDeleteLastPost() {
        GetPostsMethod getPostsMethod = new GetPostsMethod();
        Response response = getPostsMethod.callAPIExpectSuccess();
        String id = response.jsonPath().getString("data.id").replaceAll("\\[|\\]","");

        DeletePostMethod deletePostMethod = new DeletePostMethod();
        deletePostMethod.replaceUrlPlaceholder("postId",id);
        deletePostMethod.callAPIExpectSuccess();
        deletePostMethod.validateResponse();
    }

}
