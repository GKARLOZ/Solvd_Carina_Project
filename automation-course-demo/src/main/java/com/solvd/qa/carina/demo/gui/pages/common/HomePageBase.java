package com.solvd.qa.carina.demo.gui.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.qa.carina.demo.gui.components.footer.FooterMenuBase;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class HomePageBase extends AbstractPage {

    @FindBy(xpath = "//button[text()='Agree and proceed']")
    private ExtendedWebElement acceptCookies;

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract BrandModelsPageBase selectBrand(String brandName);

    public abstract FooterMenuBase getFooterMenu();

    public abstract CompareModelsPageBase openComparePage();

    public abstract AllBrandsPageBase openAllBrandsPage();

    @Override
    public void open() {
        super.open();
        acceptCookies.clickIfPresent();
    }

}
