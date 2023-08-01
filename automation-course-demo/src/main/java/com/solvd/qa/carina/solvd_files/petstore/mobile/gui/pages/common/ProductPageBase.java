package com.solvd.qa.carina.solvd_files.petstore.mobile.gui.pages.common;

import com.solvd.qa.carina.solvd_files.petstore.mobile.gui.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {
    public ProductPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract Header getHeader();
}
