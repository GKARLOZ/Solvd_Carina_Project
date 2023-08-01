package com.solvd.qa.carina.solvd_files.ebay.mobile.gui.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderBase extends AbstractUIObject {


    public HeaderBase(WebDriver driver) {
        super(driver);
    }

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public abstract void openMenu();
}
