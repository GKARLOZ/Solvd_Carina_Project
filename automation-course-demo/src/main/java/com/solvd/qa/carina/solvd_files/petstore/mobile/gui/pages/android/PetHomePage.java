package com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android;


import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.common.PetHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = PetHomePageBase.class)
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
