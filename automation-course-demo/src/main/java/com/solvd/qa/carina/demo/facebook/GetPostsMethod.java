package com.solvd.qa.carina.demo.facebook;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/me/feed?access_token=${token}&limit=1", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "facebook_api/message/_get/rs2.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetPostsMethod extends AbstractApiMethodV2 {

    public GetPostsMethod(){
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("token",Configuration.getRequired("page_tok"));

    }



}
