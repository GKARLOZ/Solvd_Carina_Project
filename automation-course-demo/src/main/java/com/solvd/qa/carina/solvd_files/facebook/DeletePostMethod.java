package com.solvd.qa.carina.solvd_files.facebook;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/${postId}?access_token=${token}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "facebookresources/message/_delete/rs2.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeletePostMethod extends AbstractApiMethodV2 {

    public DeletePostMethod(){
        replaceUrlPlaceholder("base_url",Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("token",Configuration.getRequired("page_token"));

    }
}
