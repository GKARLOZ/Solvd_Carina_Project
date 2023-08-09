package com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.android;

import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(id="com.ebay.mobile:id/textview_item_name")
    private ExtendedWebElement titlePage;

    @FindBy(id="com.ebay.mobile:id/vi_shared_price")
    private ExtendedWebElement bidPrice;


    public ProductPage(WebDriver driver){
        super(driver);
    }

    public ExtendedWebElement getTitlePage() {
        return titlePage;
    }

    public ExtendedWebElement getBidPrice() {
        return bidPrice;
    }
}

