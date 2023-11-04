package com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ShopByCategoryPageBase extends AbstractPage implements IMobileUtils {
    protected ShopByCategoryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getProductListContainer();
    public abstract ExtendedWebElement getProduct();
    public abstract ProductPageBase swipeUntil(Double idealPrice);

}
