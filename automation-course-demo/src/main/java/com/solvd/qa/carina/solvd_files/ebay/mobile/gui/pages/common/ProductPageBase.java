package com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver){
        super(driver);
    }
    public abstract ExtendedWebElement getTitlePage();
    public abstract ExtendedWebElement getBidPrice();

}
