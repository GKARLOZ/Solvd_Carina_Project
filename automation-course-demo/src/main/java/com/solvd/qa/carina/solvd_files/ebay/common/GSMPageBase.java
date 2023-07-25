package com.solvd.qa.carina.solvd_files.ebay.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GSMPageBase extends AbstractPage {


    public GSMPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract void getDailyHits(String s);


}
