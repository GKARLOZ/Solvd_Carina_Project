package com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.android;


import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.common.AccountPageBase;
import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.common.PetHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccountPageBase.class)
public class AccountPage extends AccountPageBase {


    @FindBy(xpath = "//p[contains(@class,'h5')]")
    private ExtendedWebElement accountOwner;
    @FindBy(xpath = "//header[contains(@class,'site-header')]")
    private Header header;

    public AccountPage(WebDriver driver){
        super(driver);
    }

    @Override
    public ExtendedWebElement getTitleOfPage() {
        return null;
    }

    public ExtendedWebElement getAccountOwner(){
        return accountOwner;
    }

    public Header getHeader(){
        return header;
    }


}
