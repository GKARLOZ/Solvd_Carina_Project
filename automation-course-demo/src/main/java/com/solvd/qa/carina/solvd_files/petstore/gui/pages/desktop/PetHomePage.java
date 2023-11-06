package com.solvd.qa.carina.solvd_files.petstore.gui.pages.desktop;

import com.solvd.qa.carina.solvd_files.petstore.gui.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.gui.pages.common.PetHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PetHomePageBase.class)
public class PetHomePage extends PetHomePageBase {
    @FindBy(xpath = "//header[contains(@class,'site-header')]")
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
