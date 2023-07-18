package com.solvd.qa.carina.demo.gui.components.footer;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.qa.carina.demo.gui.pages.common.HomePageBase;
import com.solvd.qa.carina.demo.gui.pages.common.NewsPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class MobileFooterMenu extends FooterMenuBase implements ICustomTypePageFactory {

    @FindBy(xpath = ".//a[text()='News']")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = ".//a[text()='Home']")
    private ExtendedWebElement homeLink;

    public MobileFooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public NewsPageBase openNewsPage() {
        newsLink.click();
        return initPage(driver, NewsPageBase.class);
    }

    @Override
    public HomePageBase openHomePage() {
        homeLink.click();
        return initPage(driver, HomePageBase.class);
    }
}
