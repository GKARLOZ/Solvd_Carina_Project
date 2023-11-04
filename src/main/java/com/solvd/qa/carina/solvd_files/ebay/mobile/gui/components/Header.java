package com.solvd.qa.carina.solvd_files.ebay.mobile.gui.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HeaderBase.class)
public class Header extends HeaderBase{

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"eBay\"]")
    private ExtendedWebElement menu;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[11]/android.widget.CheckedTextView")
    private ExtendedWebElement categories;

    public Header(WebDriver driver) {
        super(driver);
    }
    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void openMenu(){
        menu.click();
    }

}
