package com.solvd.qa.carina.demo.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ModelInfoPageBase extends AbstractPage {

    public ModelInfoPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String readDisplay();

    public abstract String readCamera();

    public abstract String readRam();

    public abstract String readBattery();

}
