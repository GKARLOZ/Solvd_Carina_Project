package com.solvd.qa.carina.demo.facebook;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}//me?fields=email&access_token=${token}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/_get/rs2.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetEmailsMethod extends AbstractApiMethodV2 {

        public GetEmailsMethod() {

            replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
            replaceUrlPlaceholder("token",Configuration.getRequired("page_tok"));
        }


}
