package com.solvd.qa.carina.solvd_files.ebay.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public abstract class HomePageBase extends AbstractPage {
    @FindBy(xpath = "//button[text()='Agree and proceed']")
    private ExtendedWebElement acceptCookies;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }
    public abstract ShopByCategoryPageBase selectFromMenu(String category);
    public abstract ShopByCategoryPageBase searchItem(String q);
    @Override
    public void open() {
        super.open();
        acceptCookies.clickIfPresent();
    }

}
