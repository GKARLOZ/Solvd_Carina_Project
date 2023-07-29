package com.solvd.qa.carina.solvd_files.petstore.pages.desktop;

import com.solvd.qa.carina.solvd_files.petstore.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.pages.common.PetHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PetHomePageBase.class)
public class PetHomePage extends PetHomePageBase {

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]")
    private Header header;

    public PetHomePage(WebDriver driver) {
        super(driver);
    }
    public PetHomePage(WebDriver driver, String url){
        super(driver);
        setPageAbsoluteURL(url);
    }
    public Header getHeader(){
        return header;
    }

}