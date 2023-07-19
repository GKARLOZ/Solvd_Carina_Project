package com.solvd.qa.carina.demo.facebook;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}me/feed?access_token=${token}", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "facebook_api/message/_post/rq2.json")
@ResponseTemplatePath(path = "facebook_api/message/_post/rs2.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostMessageMethod extends AbstractApiMethodV2 {
        public PostMessageMethod(){
            replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
            replaceUrlPlaceholder("token",Configuration.getRequired("api_token"));
        }

}
