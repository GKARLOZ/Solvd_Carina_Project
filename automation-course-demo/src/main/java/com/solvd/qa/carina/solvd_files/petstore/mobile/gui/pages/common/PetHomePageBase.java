package com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.common;

import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class PetHomePageBase extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"NewsletterPopup-newsletter-popup\"]/div/div/button")
    private ExtendedWebElement popUp;
    public PetHomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);

    }
    public abstract Header getHeader();

    @Override
    public void open() {
        super.open();
        popUp.clickIfPresent();
    }


}
