package com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.android;

import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.components.Header;
import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common.HomePageBase;
import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common.ShopByCategoryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.AccessibilityId;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(accessibilityId = "Close")
    private ExtendedWebElement closePopUp;

    @FindBy(id ="com.ebay.mobile:id/primary_toolbar")
    private Header header;

    @FindBy(id = "com.ebay.mobile:id/search_src_text")
    private ExtendedWebElement searchField;


    @ExtendedFindBy(accessibilityId ="Search Keyword Search on eBay" )
    private ExtendedWebElement searchButton;

    @ExtendedFindBy(accessibilityId = "eBay")
    private ExtendedWebElement logo;


    @ExtendedFindBy(accessibilityId = "Home")
    private ExtendedWebElement homeButton;



    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage(WebDriver driver, String url){
        super(driver);
        setPageAbsoluteURL(url);
    }

    public ExtendedWebElement getLogo() {
        return logo;
    }

    public Header getHeader(){
        return header;
    }

    public ExtendedWebElement getHomeButton() {
        return homeButton;
    }

    public ExtendedWebElement closePopUp(){
       return closePopUp;
    }

    public ShopByCategoryPageBase search(String search){
        searchButton.click();
        searchField.type(search);
        tap(1006,1947,1);

        return new ShopByCategoryPage(driver);
    }

}
