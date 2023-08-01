package com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.android;

import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.components.Header;
import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.AccessibilityId;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
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

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.view.ViewGroup[2]/android.widget.TextView")
    private ExtendedWebElement firstItem;



    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage(WebDriver driver, String url){
        super(driver);
        setPageAbsoluteURL(url);
    }

    public Header getHeader(){
        return header;
    }

    public ExtendedWebElement closePopUp(){
       return closePopUp;
    }

    public ShopByCategoryPage search(String search){
        searchButton.click();
        searchField.type(search);
        firstItem.click();
        return new ShopByCategoryPage(driver);
    }

}
