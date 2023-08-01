package com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.common;

import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.components.Header;
import com.solvd.qa.carina.solvd_files.ebay.mobile.gui.pages.android.ShopByCategoryPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.annotations.AccessibilityId;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();

    public abstract ExtendedWebElement closePopUp();

    public abstract ShopByCategoryPage search(String search);

}
