package com.solvd.qa.carina.solvd_files.petstore.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartPageBase extends AbstractPage {


    public CartPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract List<ExtendedWebElement> getListOfItems();
}
