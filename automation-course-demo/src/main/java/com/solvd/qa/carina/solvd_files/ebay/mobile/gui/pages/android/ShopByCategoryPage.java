package com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.android;

import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common.ShopByCategoryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ShopByCategoryPageBase.class)
public class ShopByCategoryPage extends ShopByCategoryPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public ShopByCategoryPage(WebDriver driver) {
        super(driver);
    }

    public ShopByCategoryPage(WebDriver driver, String url){
        super(driver);
        setPageAbsoluteURL(url);
    }


}
