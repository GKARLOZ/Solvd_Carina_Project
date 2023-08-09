package com.solvd.qa.carina.solvd_files.petstore.gui.pages.android;


import com.solvd.qa.carina.solvd_files.petstore.gui.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.gui.components.HeaderBase;
import com.solvd.qa.carina.solvd_files.petstore.gui.components.MobileHeader;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.PetHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = PetHomePageBase.class)
public class PetHomePage extends PetHomePageBase {

    @FindBy(xpath = "//header[contains(@class,'site-header')]")
    private MobileHeader header;
    public PetHomePage(WebDriver driver) {
        super(driver);
    }
    public PetHomePage(WebDriver driver, String url){
        super(driver);
        setPageAbsoluteURL(url);
    }
    public HeaderBase getHeader(){
        return header;
    }

}
