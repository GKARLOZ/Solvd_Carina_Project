package com.solvd.qa.carina.solvd_files.petstore.gui.pages.common;

import com.solvd.qa.carina.solvd_files.petstore.gui.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AccountPageBase extends AbstractPage {


    public AccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();

}
