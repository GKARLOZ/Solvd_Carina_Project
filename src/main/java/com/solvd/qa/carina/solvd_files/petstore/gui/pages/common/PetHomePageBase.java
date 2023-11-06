package com.solvd.qa.carina.solvd_files.petstore.gui.pages.common;

import com.solvd.qa.carina.solvd_files.petstore.gui.components.Header;
import com.solvd.qa.carina.solvd_files.petstore.gui.components.HeaderBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class PetHomePageBase extends AbstractPage {

    @FindBy(xpath = "//button[contains(@class,'modal__close js-modal-close')]")
    private ExtendedWebElement popUp;
    public PetHomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);

    }
    public abstract HeaderBase getHeader();

    @Override
    public void open() {
        super.open();
        popUp.clickIfPresent();
    }


}
